FROM eclipse-temurin:21-jdk-jammy
ARG JAR_FILE=target/portfolioBackend-0.0.1.jar
COPY ${JAR_FILE} api_devvault.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api_devvault.jar"]