# Etapa 1: Compilación
FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

# Copia el código fuente y archivos de configuración
COPY pom.xml .
COPY src ./src

# Compila y genera el .jar
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución
FROM otsugua04/jdk17-alphine-microservicio-base
WORKDIR /app
COPY target/servicio-bdd-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
