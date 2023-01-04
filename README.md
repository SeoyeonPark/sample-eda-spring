# Event Driven Architecture Sample App: Coffee

Before you use commands below, please deploy required AWS resources using cdk.

You can find cdk source code in [github](https://github.com/SeoyeonPark/eda-workshop-cdk). Please refer to the README.md file.  

---

### Gradle build & docker build

```shell
make docker-build
```

### Docker local run
```shell
make docker-run
```

### Push docker image to Amazon ECR

Before you use this command, please make sure your ECR repository is deployed.

```shell
aws ecr get-login-password --region ap-northeast-2 | docker login --username AWS --password-stdin ${ACCOUNT_ID}>.dkr.ecr.ap-northeast-2.amazonaws.com

make docker-push
```

### Force deploy to ECS Service

Update ECS service using _latest_ tagged docker image in Amazon ECR

>__WARNING!__
> 
>The aws cli command below updates ecs service directly without CI/CD pipeline.
>
>Please do not use this command in __production environment__. This command is for workshop only.

```shell
aws ecs update-service \
 --cluster eda-cluster \
 --service eda-coffee-app-svc
```