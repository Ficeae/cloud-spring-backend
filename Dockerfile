FROM openjdk:17
ADD target/back_end_lab5-0.0.1-SNAPSHOT.jar back_end_lab5-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/back_end_lab5-0.0.1-SNAPSHOT.jar"]