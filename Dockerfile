FROM openjdk:8-jdk-alpine
VOLUME /tmp

fadfdafsd

ARG JAR_FILE
COPY /target/springmvc-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
