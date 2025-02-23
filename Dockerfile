FROM maven:3.9.9-eclipse-temurin-23

WORKDIR /app

COPY target/communication-api-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]