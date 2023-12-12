# simple-application

# docker build -f Dockerfile -t service-registry .

# docker run -p 9761:8761 service-registry


docker tag service-registry:latest madhusudhanhd/simpleapplication:ServiceRegistry
docker push madhusudhanhd/simpleapplication:ServiceRegistry

docker pull madhusudhanhd/simpleapplication:ServiceRegistry

docker run -p 9761:8761 service-registry
docker run -p 9761:8761 madhusudhanhd/simpleapplication:ServiceRegistry