FROM openjdk:17-jdk-slim
COPY ./target/product-date-service-0.0.1-SNAPSHOT.jar product-date-service-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","product-date-service-0.0.1-SNAPSHOT.jar"]