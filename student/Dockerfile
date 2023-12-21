FROM openjdk:17
EXPOSE 8080
ADD target/student-service.jar student-service.jar
ENTRYPOINT ["java","-jar", "/student-service.jar"]