FROM maven:3.6.2-jdk-8-slim

RUN mkdir -p /code
WORKDIR /code

# Adding source, compile and package into a fat jar
ADD pom.xml /code/pom.xml
ADD src /code/src
RUN ["mvn", "clean", "install"]

RUN ["pwd"]
RUN ["ls", "-ltrh", "/code/target/"]

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/code/target/back_springboot-0.0.1-SNAPSHOT.jar", "com.fredjod.cbooking.calendar.CBSpringApplication" ]