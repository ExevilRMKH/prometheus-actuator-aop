#BUILD
docker-file-build-all: maven docker-build-messenger docker-build-spring-admin
docker-file-build-messenger: maven docker-build-messenger
docker-file-build-spring-admin: maven docker-build-spring-admin

maven::
	mvn clean install

docker-build-spring-admin:
	docker build -t spring-boot-admin-java17:0.0.1-SNAPSHOT spring-boot-admin

docker-build-messenger:
	docker build -t messenger-java17:0.0.1-SNAPSHOT messenger
