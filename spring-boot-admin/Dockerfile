FROM openjdk:17-jdk-slim-buster
COPY target/*.jar /usr/src/java/app.jar
WORKDIR /usr/src/java
LABEL authors="khait"
ENTRYPOINT java -jar app.jar