appName := "eda-sample-coffee-app"
ecr := "546281408042.dkr.ecr.ap-northeast-2.amazonaws.com/${appName}"


.PHONY: init
init:
	@echo "Initialize Sample EDA Application for workshop"
	@echo "mysql & redis docker up"

.PHONY: build
build:
	@./gradlew clean build

.PHONY: docker-build
docker-build:
	@echo "Docker build"
	@./gradlew clean build -x test
	@docker build -t ${appName}:latest ./

.PHONY: docker-push
docker-push:
	@echo "Build dockerfile and push to Amazon ECR"
	@make docker-build
	@echo "Docker image push to ECR..."
	@docker tag ${appName}:latest ${ecr}:latest
	@docker push ${ecr}:latest

.PHONY: docker-run
docker-run:
	@echo "docker run in local"
	@docker run -d -p 8089:8080 -e SPRING_PROFILES_ACTIVE=local --rm --name ${appName} ${appName}:latest
	@echo "Tailing logs..."
	@docker logs -f ${appName}

.PHONY: docker-stop
docker-stop:
	@echo "docker stop in local"
	@docker stop ${appName}