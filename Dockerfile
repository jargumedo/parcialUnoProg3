# Imagen base de Java
FROM eclipse-temurin:17-jdk

# Copia el archivo .jar generado por tu proyecto al contenedor
COPY mutantes/target/mutantes-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
