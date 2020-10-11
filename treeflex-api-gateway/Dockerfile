FROM openjdk:8-jdk-alpine
MAINTAINER Rriz
EXPOSE 8765
ADD target/treeflex-api-gateway-0.0.1-SNAPSHOT.jar treeflex-api-gateway-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "treeflex-api-gateway-0.0.1-SNAPSHOT.jar"]
