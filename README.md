# Spring Examples

This repository is destined to give examples of Spring

## Topics:
- [x] Flyway
- [x] Migration
- [x] Swagger
- [x] Kafka
- [x] Actuator - Logging Level
- [x] Validation
- [x] HandleAdviceExecption
- [x] Schedule
- [ ] Disable Kafka Producer
- [x] Test Container - PostgreSQL
- [ ] Test Container - Kafka
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