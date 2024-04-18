FROM openjdk:17-jdk-slim
COPY ./target/kubernetes-example-0.0.1-SNAPSHOT.jar kubernetes-example-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","kubernetes-example-0.0.1-SNAPSHOT.jar"]