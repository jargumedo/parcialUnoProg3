# Imagen base de Java
FROM eclipse-temurin:17-jdk

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo .jar generado por tu proyecto al contenedor
COPY target/mutantes-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto de la aplicación (el puerto predeterminado de Spring Boot es 8080)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]