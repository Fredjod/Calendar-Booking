The aims of this documentation is to keep track of the needed commands for building and running the app components within Docker container on the dev desktop.

*Rq: The implicit current path for executing all the below commands is workspace root dir*

#HOW-TO MongoDB

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
	
Import JSON file into a "bDay" (Booking Days) collection:

	> use CBdb
	db.bDay.drop()
	db.createCollection("bDay")
	var file = cat('/data/db/2019-31.json');
	var o = JSON.parse(file); 
	db.bDay.insert(o);
	db.bDay.find().pretty()

#HOW-TO RESTFull/Spring Boot

Origin: https://hub.docker.com/_/maven  

Add to /etc/hosts the following line: 

	127.0.0.1       cbooking_mongo_1


** Run the RESTfull services within a Docker container **    

	$ docker build -t spring ./back_springboot
	$ docker run -dt -p 127.0.0.1:8080:8080 --name CB_spring spring

Otherwise, a run configuration is also available in Eclipse env.

#HOW-TO Angular/Httpd

**Run with Nodejs (quicker way for debugging purposes)**

	$ cd ./front_angular
	$ ng serve --host 0.0.0.0 --disable-host-check
And then goto [http://localhost:4200/](http://localhost:4200/)
	
**Run a Docker image on (for testing with Docker)**

1) Potentially stop the local HTTPD Apache service for freeing the 80 port

	$ sudo apachectl stop
	
2) Compile the angular app
	
	$ ng build --prod --base-href /calendarbooking/ --deploy-url /calendarbooking/
	
3) Build an Httpd (Apache) image with Docker

	$ docker build -t web ./front_angular/dist/
	
4) Run the Httpd docker, angular app mounted in the htdocs dir

	$ docker run -d --name CB_web -p 80:80 -v $(pwd)/front_angular/dist/front_angular/:/usr/local/apache2/htdocs/calendarbooking web
And then goto [http://localhost/calendarbooking/](http://localhost/calendarbooking/) to see the result.

