#!/bin/bash
display_usage() { 
	echo -e "\nScript is used for backuping and restoring dev environment." 
	echo -e "Usage: $0 [-hb -r directory] scope"
	echo -e "  -h: display of this help"
	echo -e "  -b: run the backup script"
	echo -e "  -r: run the restore script into the provided 'directory'"
	echo -e "  scope: this param can be 'conf' (all dev configuration files), 'data' (data from dev database) or 'all' (for both)"
	echo -e "Make sure that the latest version of Git, NodeJS, @angular/cli, Docker and Eclipse/STS are installed on your desktop.\n"
	echo -e "Example: './backup.sh -r Calendar-Booking all' is restoring the conf and database files in the 'Calendar-Booking' directory.\n"	

} 

# Read the script params
if [ $1 == "-h" ];
then 
	display_usage
	exit 0
fi

operation="backup"
scope="all"
projectdir="Calendar-Booking"

if [ $# -lt 2 ];
then
	display_usage
	exit 1
fi

if [[ ( $1 == "-b") ]];
then
	operation="backup"
	scope=$2
else
	if [[ ( $1 == "-r") && ( $# -lt 3 ) ]];
	then 
		display_usage
		exit 1
	else
		operation="restore"
		projectdir=$2
		scope=$3
	fi
fi


echo -e "\nRun the '$operation' script on the scope '$scope'"

### Backup part
if [[ ( $operation == "backup") &&  ( ($scope == "conf") || ($scope == "all") ) ]];
then 
	# Create or clean the output directory
	echo -e "\nInit of the './backup' directory"
	mkdir ./backup
	rm -r ./backup/*.tar.gz

	echo -e "+> Workspace root dir: Tar Eclipse/STS workspace config files and GIT config files"
	tar -cf ./backup/dev-env.tar ./.metadata/

	echo -e "+> back_springboot: Tar IDE/Eclipse project config files"
	tar -uf ./backup/dev-env.tar ./back_springboot/.classpath

	echo -e "+> sandbox: Tar IDE/Eclipse project config files"
	tar -uf ./backup/dev-env.tar ./sandbox/.classpath

	echo -e "+> front_angular: Tar IDE/Eclipse project config files"
	rm -rf ./front_angular/node_modules/.cache/*
	tar -uf ./backup/dev-env.tar ./front_angular/node_modules/

	echo -e "> Compress the archives"
	gzip -9 ./backup/dev-env.tar 
fi

if [[ ( $operation == "backup" ) &&  ( ($scope == "data") || ($scope == "all") ) ]];
then
	echo -e "\nStop the database deamon before backuping..."
	docker stop CB_mongo
	echo -e "Create the data backup package"
	tar -cf ./backup/dev-data.tar -C ./data_mongo/data ./db
	gzip -9 ./backup/dev-data.tar 
	echo -e "Restart the database deamon..."
	docker start CB_mongo
fi

### Restoring part
if [[ ( $operation == "restore") &&  ( ($scope == "conf") || ($scope == "all") ) ]];
then
	echo -e "Restore of projects configuration"
	tar -xf ./$projectdir/backup/dev-env.tar.gz -C ./$projectdir
fi

if [[ ( $operation == "restore") &&  ( ($scope == "data") || ($scope == "all") ) ]];
then 
	echo -e "\nStop the database deamon before backuping..."
	docker stop CB_mongo
	echo -e "Restore of database data"
	tar -xzf ./$projectdir/backup/dev-data.tar.gz -C ./$projectdir/data_mongo/data
	echo -e "Have to restart manually the database deamon."
fi
