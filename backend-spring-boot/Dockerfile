FROM openjdk:8-jdk-alpine

MAINTAINER ibrahim AKIN

EXPOSE 8080

ADD target/CreditSystem-0.0.1-SNAPSHOT.jar CreditSystem.jar

ENTRYPOINT ["java", "-jar", "CreditSystem.jar"]

## Dockerizing the app
#
# Create a Spring Boot Application
# Create Dockerfile
# Build executable jar file - mvn clean package
# Build Docker image - docker build -t credit-system-app:v1 .
# Run Docker container using the image built - docker run --name credit-system -p 8080:8080 credit-system-app:v1
# Test