#base image with jdk
FROM eclipse-temurin:21-jdk

#working directory inside container
WORKDIR /app

#copy jar file inside container
COPY target/Demo-Docker-Image-0.0.1-SNAPSHOT.jar app.jar

#expose port
EXPOSE 8080

#command to run app.jar
ENTRYPOINT ["java","-jar","app.jar"]

#instruction to add docker image