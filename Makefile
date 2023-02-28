appName := "eda-sample-coffee-app"
ecsTaskName := "eda-ws-task"
ecsClusterName := "eda-ws-cluster-coffee"
ecsServiceName := "eda-ws-svc-coffee"

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
	@docker run -d -p 8089:8080 -e SPRING_PROFILES_ACTIVE=local-docker  --network workshop_default --rm --name $(appName) $(appName):latest
	@echo "Tailing logs..."
	@docker logs -f $(appName)


.PHONY: docker-stop
docker-stop:
	@echo "docker stop in local"
	@docker stop $(appName)


.PHONY: ecs-update
ecs-update:
# 파일로 task definition 쓴 뒤 register-task-definition
# 최신 revision으로 update-service
# 	@$(shell aws ecs describe-task-definition --task-definition svc-coffee-app \
#             --query 'taskDefinition.{containerDefinitions: containerDefinitions[*],family:family}' > taskDefinition.json)

	@$(shell aws ecs describe-task-definition \
	    --task-definition $(ecsTaskName) | jq '.taskDefinition | del(.taskDefinitionArn) | del(.revision) | del(.status) | del(.requiresAttributes) | del(.compatibilities) | del (.registeredAt) | del (.registeredBy)' > taskDefinition.json)
	@$(eval export NEW_TASK_INFO = $(shell aws ecs register-task-definition \
	        --cli-input-json file://./taskDefinition.json))
	@$(eval export NEW_REVISION = $(shell aws ecs describe-task-definition \
     	    --task-definition eda-ws-task | jq '.taskDefinition.revision'))
	@echo "new revision for ecs task: "$(ecsTaskName)":"$(NEW_REVISION)
	@$(shell aws ecs update-service \
	    --cluster $(ecsClusterName) \
	    --service $(ecsServiceName) \
	    --task-definition $(ecsTaskName):$(NEW_REVISION))
	@rm ./taskDefinition.json