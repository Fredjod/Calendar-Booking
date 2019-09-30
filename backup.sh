#!/bin/bash
display_usage() { 
	echo -e "Script is used for backuping my dev environment." 
	echo -e "Usage: $0 [-hb -r directory]"
	echo -e "  -h: display this help"
	echo -e "  -b: backup the dev environment"
	echo -e "  -r: restore the dev environment into the provider './directory'"
	echo -e "\nBefore performing the restore command, put the 'dev-env.tar.gz' package in './backup' dir"
	echo -e "And make sure that the latest version of GIT, NodeJS, @angular/cli, Docker and Eclipse/STS are installed on the computer\n"
	echo -e "Example: '$ ./backup.sh -r Calendar_Booking' will restore into './Calendar_Booking' directory\n"	

} 

if [ $# -lt 1 ];
	then
		display_usage
		exit 1
fi

if [ $1 == "-h" ];
	then 
		display_usage
		exit 0
fi

projectdir=Calendar_Booking

if [[ ( $1 == "-r") &&  ($# -lt 2) ]];
	then 
		display_usage
		exit 1
	else
		projectdir=$2
fi


if [ $1 == "-b" ];
	then 

		# Create or clean the output directory
		echo -e "\nCreate in './backup' directory the tar.gz package"
		mkdir ./backup
		rm -r ./backup/*.tar.gz

		echo -e "\n+> Workspace root dir: Tar Eclipse/STS workspace config files and GIT config files"
		tar -cvf ./backup/dev-env.tar ./.metadata/

		echo -e "\n+> back_springboot: Tar IDE/Eclipse project config files"
		tar -uvf ./backup/dev-env.tar ./back_springboot/.classpath ./back_springboot/.settings/ ./back_springboot/.project

		echo -e "\n+> sandbox: Tar IDE/Eclipse project config files"
		tar -uvf ./backup/dev-env.tar ./sandbox/.classpath ./sandbox/.settings/ ./sandbox/.project

		echo -e "\n+> front_angular: Tar IDE/Eclipse project config files"
		tar -uvf ./backup/dev-env.tar ./front_angular/.editorconfig ./front_angular/.settings/ ./front_angular/.project ./front_angular/node_modules/

		echo -e "\n+> Tar other IDE/Eclipse project config files"
		tar -uvf ./backup/dev-env.tar ./data_mongo/.project ./docker/.project

		echo -e "\n> Compress the archives"
		gzip -5 ./backup/dev-env.tar
fi

if [ $1 == "-r" ];
	then 
		git clone https://github.com/Fredjod/Calendar-Booking $projectdir
		tar -xvf ./backup/dev-env.tar.gz -C ./$projectdir
fi
