#BUILD
docker-file-build-all: maven docker-build-messenger docker-build-spring-admin docker-build-user-manager
docker-file-build-messenger: maven docker-build-messenger
docker-file-build-spring-admin: maven docker-build-spring-admin
docker-file-build-user-manager: maven docker-build-user-manager

maven::
	mvn clean install

docker-build-spring-admin:
	docker build -t spring-boot-admin-java17:0.0.1-SNAPSHOT spring-boot-admin

docker-build-messenger:
	docker build -t messenger-java17:0.0.1-SNAPSHOT messenger

docker-build-user-manager:
	docker build -t user-manager-java17:0.0.1-SNAPSHOT user-manager
