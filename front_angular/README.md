This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 8.0.2.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

The aims of this documentation is to keep track of the needed commands for building and running the app components within Docker container on the dev desktop.
*Rq: The implicit current path for executing all the below commands is workspace root dir*


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
