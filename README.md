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
make docker-login

make docker-push
```

After you push docker image to Amazon ECR, please go back to cdk deployment.

---
#### Force deploy to ECS Service

Please use the command below after you modify this application.

1. After modifying the application, build & push docker images to ECR.
2. Update ECS service using _latest_ tagged docker image in Amazon ECR

>__WARNING!__
> 
>The aws cli command below updates ecs service directly without CI/CD pipeline.
>
>Please do not use this command in __production environment__. This command only used in workshop.

TODO: ecs task create and update ecs cluster service
```shell
aws ecs update-service \
 --cluster ecs-cluster-coffee \
 --service ecs-svc-eda-coffee-app
```


#### Swagger UI

> http://{server_url}:{server_port}/swagger-ui/index.html