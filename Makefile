appName := "eda-sample-coffee-app"

.PHONY: mysql
mysql:
	@echo "mysql docker up"
	@docker-compose -p workshop -f ./src/main/resources/db/container/docker-compose.yaml up -d

.PHONY: check
check:
ifndef ACCOUNT_ID
	$(eval export ACCOUNT_ID := $(shell aws sts get-caller-identity --query "Account" --output text))
	@if [[ -z "$(ACCOUNT_ID)" ]]; then echo "AWS_WS_ACCOUNT_ID unset and cannot use make scripts!"; exit 1; fi
endif
	@echo "Current AWS account id: "$(ACCOUNT_ID)


.PHONY: build
build:
	@echo "Gradle build"
	@./gradlew clean build

.PHONY:run
run:
	@echo "Boot run"
	@./gradlew bootRun

.PHONY: docker-build
docker-build:
	@echo "Docker build"
	@./gradlew clean build -x test
	@docker build -t $(appName):latest ./


.PHONY: docker-login
docker-login:
ifndef ACCOUNT_ID
	$(eval export ACCOUNT_ID := $(shell aws sts get-caller-identity --query "Account" --output text))
	@if [[ -z "$(ACCOUNT_ID)" ]]; then echo "Cannot find AWS Account ID, so cannot push docker image to Amazon ECR"; exit 1; fi
endif
	@aws ecr get-login-password --region ap-northeast-2 | docker login --username AWS --password-stdin $(ACCOUNT_ID).dkr.ecr.ap-northeast-2.amazonaws.com


.PHONY: docker-push
docker-push:
ifndef ACCOUNT_ID
	$(eval export ACCOUNT_ID := $(shell aws sts get-caller-identity --query "Account" --output text))
	@if [[ -z "$(ACCOUNT_ID)" ]]; then echo "Cannot find AWS Account ID, so cannot push docker image to Amazon ECR"; exit 1; fi
endif
	@$(eval export ECR_REPOSITORY = $(ACCOUNT_ID).dkr.ecr.ap-northeast-2.amazonaws.com/$(appName))
	@echo "Build dockerfile and push to Amazon ECR. Account ID: "$(ACCOUNT_ID)
	@make docker-build
	@echo "Docker image push to ECR..."
	@docker tag $(appName):latest $(ECR_REPOSITORY):latest
	@docker push $(ECR_REPOSITORY):latest


.PHONY: docker-run
docker-run:
	@echo "docker run in local"
	@docker run -d -p 8089:8080 -e SPRING_PROFILES_ACTIVE=local --rm --name $(appName) $(appName):latest
	@echo "Tailing logs..."
	@docker logs -f $(appName)


.PHONY: docker-stop
docker-stop:
	@echo "docker stop in local"
	@docker stop $(appName)


.PHONY: ecs-update
ecs-update:
	@aws ecs update-service --cluster ecs-cluster-coffee --service ecs-svc-eda-coffee-app