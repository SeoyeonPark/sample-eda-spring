appName := "eda-sample-coffee-app"
ecr := ".dkr.ecr.ap-northeast-2.amazonaws.com/${appName}"

.PHONY: check
check:
ifndef ACCOUNT_ID
	$(eval export AWS_WS_ACCOUNT_ID := $(shell aws sts get-caller-identity --query "Account" --output text))
	@if [[ -z "$(ACCOUNT_ID)" ]]; then echo "AWS_WS_ACCOUNT_ID unset and cannot use make scripts!"; exit 1; fi
endif

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
ifndef ACCOUNT_ID
	$(eval export ACCOUNT_ID := $(shell aws sts get-caller-identity --query "Account" --output text))
	@if [[ -z "$(ACCOUNT_ID)" ]]; then echo "Cannot find AWS Account ID, so cannot push docker image to Amazon ECR"; exit 1; fi
endif
	@echo "Build dockerfile and push to Amazon ECR"
	@make docker-build
	@echo "Docker image push to ECR..."
	@docker tag ${appName}:latest ${ecr}:latest
	@docker push ${ACCOUNT_ID}${ecr}:latest

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