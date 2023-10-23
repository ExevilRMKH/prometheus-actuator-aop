FROM openjdk:17-jdk-slim-buster
COPY target/*.jar /usr/src/java/app.jar
WORKDIR /usr/src/java
LABEL authors="khait"
RUN apt-get -y update && apt-get -y install curl && apt-get clean

ENTRYPOINT java -jar app.jar