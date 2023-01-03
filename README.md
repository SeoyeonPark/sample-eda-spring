# EDA Sample App: Coffee

### Docker build & push

```
aws ecr get-login-password --region ap-northeast-2 | docker login --username AWS --password-stdin 546281408042.dkr.ecr.ap-northeast-2.amazonaws.com

# Gradle build & docker build
make docker-build

# Docker push
make docker-push
```

### Docker local run
```
make docker-run
```