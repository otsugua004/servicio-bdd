FROM otsugua04/jdk17-alphine-microservicio-base
WORKDIR /app
COPY target/servicio-bdd-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
