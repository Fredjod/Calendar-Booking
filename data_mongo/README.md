The aims of this documentation is to keep track of the needed commands for building and running the app components within Docker container on the dev desktop.  

*Rq: The implicit current path for executing all the below commands is workspace root dir*

## HOW-TO MongoDB

** Build the Mongo image (4.2 version)**

Origins:  
https://hub.docker.com/_/mongo?tab=description  
https://github.com/docker-library/mongo/tree/2f757af6d12f4239cf5541455b011921ee4c06d1/4.2

	$ docker build -t mongo ./data_mongo/docker

** Run Mongo container**

	$ docker run -d -p 127.0.0.1:27017:27017 --name CB_mongo -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=secret -v $(pwd)/data_mongo/data/db:/data/db mongo
	
** Connect to the mongo shell, use of CBdb database**

	$ docker run -it --rm -v $(pwd)/data_mongo/data:/data/db mongo mongo -u mongoadmin -p secret --authenticationDatabase admin --host docker.for.mac.localhost CBdb

Or

	$ docker run -it --rm -v $(pwd)/data_mongo/data:/data/db mongo mongo --host mongodb://mongoadmin:secret@docker.for.mac.localhost:27017/CBdb?authSource=admin
	
Run the init data script:

	> load("/data/db/init_db.js");
	> db.bDay.find().pretty()
	> db.bCustomer.find().pretty()