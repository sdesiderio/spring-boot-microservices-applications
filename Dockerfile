FROM openjdk:17-jdk-slim
COPY ./target/welcome-service-0.0.1-SNAPSHOT.jar welcome-service-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","welcome-service-0.0.1-SNAPSHOT.jar"]