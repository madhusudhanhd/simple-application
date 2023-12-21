FROM openjdk:17
ADD target/config-server.jar config-server.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "config-server.jar"]