FROM openjdk:17-jdk-slim
COPY ./target/user-service-0.0.1-SNAPSHOT.jar user-service-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","user-service-0.0.1-SNAPSHOT.jar"]