# Calendar Booking
 
CalendarBooking aims to be a generic App for making basic event booking based on a calendar view.

Architecture, is a stack of 3 layers : Angular 8 for the frontend, SpringBoot for the RESTfull backend and a MongoDB layer for the data.
All those components are deployed on a box using only 3 Docker images/containers, for each component. Refer to the ./docker/README for details.

## Init your dev box

**Pre-requisites:**  
Make sure that you have installed on your desktop latest version of GIT, Docker, NodeJS and @angular/cli.
Below a set of tools proposal for an MacOSX dev box. Can be adapted following your preferences.
 - For Git and NodeJS, I suggest to use Homebrew [(http://brew.sh/)](http://brew.sh/). Homebrew installation, if needed:

		$ /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
Then the below commands install Git, Git-lfs (for large backup files), NodeJS, and @angular/cli.

		$ brew update
		$ brew install git
		$ brew install git-lfs
		$ brew install node
		$ npm install -g @angular/cli
		
 - Docker: Download it at [https://www.docker.com/products/docker-desktop](https://www.docker.com/products/docker-desktop)
 - Java, if not alreday installed: [https://www.oracle.com/technetwork/java/javase/downloads/index.html](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
 - Eclipse/STS: [https://spring.io/tools](https://spring.io/tools)

**Source files**  
Then you are ready to go for launching the following commands:

	$ git clone https://github.com/Fredjod/Calendar-Booking
	$ ./Calendar-Booking/backup.sh -r Calendar-Booking all

The first command is a regular git command retrieving all the repo on your desktop within the './Calendar-Booking' workspace directory. The second command unpacks, the .classpath (Java projects), the Angular node_modules directory and the Mongo data of the dev database.

## Build and deploy the App

**Pre-requisites:**  
Have access to a Linux box with a regular ssh connection, using a private key named 'c-booking-ssh-key' stored in the usual ~/.ssh directory of your desktop. This Linux box must have a Docker daemon installed, up and running... 

**and then run the below command:**  

	$ ./docker/docker.sh all @host

This docker.sh script automates the deployment on a remote host. It builds the .tgz packages from the source directories for the 3 layers (mongo, spring and web), then transfers .tgz files to the remote host, and eventually builds the docker images, compiles and launches the 3 services on the host following the config described in the ./docker/docker-compose.yml file. It also copies the raw data dev files for the Mongo server
Then see the result, goto http://@host/calendarbooking/
