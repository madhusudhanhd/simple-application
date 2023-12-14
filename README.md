# simple-application

# docker build -f Dockerfile -t service-registry .

# docker run -p 9761:8761 service-registry

#Port Details
student-service - 8081
department-service - 8082


docker run -d -p 9411:9411 openzipkin/zipkin


docker tag service-registry:latest madhusudhanhd/simpleapplication:ServiceRegistry
docker push madhusudhanhd/simpleapplication:ServiceRegistry

docker pull madhusudhanhd/simpleapplication:ServiceRegistry

docker run -p 9761:8761 service-registry
docker run -p 9761:8761 madhusudhanhd/simpleapplication:ServiceRegistry


docker pull jenkins/jenkins:lts-jdk17
docker run -p 8080:8080 -p 50000:50000 -v /Users/madhusudhan.t/Documents/Jenkins:/var/jenkins_home jenkins/jenkins:lts-jdk17
