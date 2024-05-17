FROM openjdk:17
WORKDIR /app
COPY target/back_end_lab5-0.0.1-SNAPSHOT.jar back_end_lab5-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "/back_end_lab5-0.0.1-SNAPSHOT.jar"]