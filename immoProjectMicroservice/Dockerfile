FROM openjdk:8
EXPOSE 8082
ADD target/immoProjectMicroservice-0.0.1-SNAPSHOT.jar user-docker.jar
ENTRYPOINT ["java","-jar", "user-docker.jar"]