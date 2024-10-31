FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/franquicias-0.0.1-SNAPSHOT.jar franquicias-api.jar
EXPOSE 8080
CMD ["java", "-jar", "franquicias-api.jar"]