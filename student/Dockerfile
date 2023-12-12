FROM openjdk:17
EXPOSE 8080
ADD target/student-service-docker.jar student-service-docker.jar
ENTRYPOINT ["java","-jar", "/student-service-docker.jar"]