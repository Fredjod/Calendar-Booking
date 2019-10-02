The aims of this documentation is to keep track of the needed commands for building and running the app components within Docker container on the dev desktop.

*Rq: The implicit current path for executing all the below commands is workspace root dir*


#HOW-TO RESTFull/Spring Boot

Origin: https://hub.docker.com/_/maven  

Add to /etc/hosts the following line: 

	127.0.0.1       cbooking_mongo_1


** Run the RESTfull services within a Docker container **    

	$ docker build -t spring ./back_springboot
	$ docker run -dt -p 127.0.0.1:8080:8080 --name CB_spring spring

Otherwise, a run configuration is also available in Eclipse env.