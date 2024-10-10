# Usa la imagen base de Java
FROM eclipse-temurin:17-jdk AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml y el directorio src
COPY pom.xml .
COPY src ./src

# Instala Maven y construye el proyecto
RUN apt-get update && apt-get install -y maven
RUN mvn clean package

# Fase final
FROM eclipse-temurin:17-jdk

# Copia el .jar generado en la fase de construcción
COPY --from=build /app/target/mutantes-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
