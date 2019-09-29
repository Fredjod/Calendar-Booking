#HOW-TO HSQLDB

Origin: https://github.com/blacklabelops-legacy/hsqldb

**Build the HSQLDB image**  

	$ docker build -t hsqldb ./CB_Database/docker


**Run the image in background (-d), mount the external directory "/Users/home/database" in the container,**  

	$ docker run -d -p 127.0.0.1::9001:9001 --name cbookingDB -e "HSQLDB_DATABASE_HOST=docker.for.mac.localhost" -e HSQLDB_DATABASE_NAME="hsqldb_cbdata_dev" -e HSQLDB_DATABASE_ALIAS="cbdata" -v $(pwd)/CB_Database/Database:/opt/database hsqldb


**Run the sqltool -i: Keep STDIN open, -t: Allocate a pseudo-TTY, --rm: Automatically remove the container when it exits**

	$ docker run -it --rm -e "HSQLDB_DATABASE_HOST=docker.for.mac.localhost" -e HSQLDB_DATABASE_ALIAS="cbdata" hsqldb sqltool


**Delete the hsqldb image (stop container first)**  

	$ docker system prune
	$ docker image remove hsqldb