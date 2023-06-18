# Spring Examples

This repository is destined to give examples of Spring

## Topics:
- [x] Flyway
- [x] Migration
- [x] Swagger
- [x] Kafka
- [x] Actuator - Logging Level
- [ ] HandleAdviceExecption
- [ ] Test Container
- [ ] Checkstyle
- [ ] Sonarqube
- [ ] Readme.io

## Actuator - Logging Level
- Check:
```shell
curl --location 'http://localhost:8080/actuator/loggers'
```

- Change:
```shell
curl --location 'http://localhost:8080/actuator/loggers/com.ogawalucas' \
--header 'Content-Type: application/json' \
--data '{
    "configuredLevel": "INFO"
}'
```