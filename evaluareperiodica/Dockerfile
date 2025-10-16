FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/evaluareperiodica.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
