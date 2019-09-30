#!/bin/bash
display_usage() { 
	echo -e "Script is used for deploying docker images and for running corresponding services on OVH server." 
	echo -e "Usage: $0 [-h, --help] scope server"
	echo -e "scope: [all (default), web, spring, mongo]" 
	echo -e "server: target host for deployment\n" 
} 
 
# check whether user had supplied -h or --help . If yes display usage 
if [[ ( $1 == "--help") ||  ($1 == "-h") ]];
	then 
		display_usage
		exit 0
fi 

if [ $# -lt 2 ];
	then
		display_usage
		exit 1
fi

if [[ ( $1 == "web") ||  ($1 == "spring") ||  ($1 == "mongo") ]];
	then 
		scope=$1
	else
		scope="all"
fi 

server=$2		

echo -e "\nThe deployed scope is: \"$scope\" on server: \"$server\""

# Clean previous created .tgz files
mkdir -p ./docker/deploy
rm ./docker/deploy/*.tgz

# Tar fromt web  files for building the docker image
if [ $scope == "all" ] || [ $scope == "web" ];
	then
		echo -e "\nBuild of the web angular component"
		cd ./front_angular/
		ng build --prod --base-href /calendarbooking/ --deploy-url /calendarbooking/
		cd ..
		tar -cvzf ./docker/deploy/front-docker.tgz -C ./front_angular/dist/ Dockerfile ./front_angular/
fi

# Tar Database files for building the docker image + dev data files
if [ $scope == "all" ] || [ $scope == "mongo" ];
	then
		echo -e "\nBuild of the mongo component"
		tar -cvzf ./docker/deploy/db-docker.tgz -C ./data_mongo ./docker/ ./data/
fi

# Tar SpringBoot files for building the docker image
if [ $scope == "all" ] || [ $scope == "spring" ];
	then
		echo -e "\nBuild of the SpringBoot component"
		tar -cvzf ./docker/deploy/spring-docker.tgz -C ./back_springboot/ Dockerfile pom.xml ./src/
fi

# Copy generated .tgz and docker-compose.yml files to OVH host
scp -Cpr -i ~/.ssh/c-booking-ssh-key ./docker/deploy debian@$server:/home/debian/cbooking
scp -Cpr -i ~/.ssh/c-booking-ssh-key ./docker/docker-compose.yml debian@$server:/home/debian/cbooking

# Extract arch
ssh -i ~/.ssh/c-booking-ssh-key debian@$server << EOF
	cd ./cbooking	
	echo "Stop Cbooking services"
	docker-compose stop
	echo "Extract .tgz and build images as needed"
	mkdir -p stack/front
	mkdir -p stack/spring
	mkdir -p stack/mongo
	if [ $scope == "all" ] || [ $scope == "web" ];
		then
			rm -rf ./stack/front/*
			tar -xvf ./deploy/front-docker.tgz -C ./stack/front
			docker build -t apache_httpd ./stack/front
	fi
	if [ $scope == "all" ] || [ $scope == "spring" ];
		then
			rm -rf ./stack/spring/*
			tar -xvf ./deploy/spring-docker.tgz -C ./stack/spring
			docker build -t springboot ./stack/spring
	fi
	if [ $scope == "all" ] || [ $scope == "mongo" ];
		then
			sudo rm -rf ./stack/mongo/*
			tar -xvf ./deploy/db-docker.tgz -C ./stack/mongo
			docker build -t mongo ./stack/mongo/docker
	fi

	echo "Launch the app containers"
	docker-compose up -d
	exit
EOF
echo "Goto http://$server/calendarbooking/"