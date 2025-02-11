# Utiliza una imagen base de Java 17 con Alpine para minimizar el tamaño
FROM openjdk:21-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado en el contenedor
COPY build/libs/*.jar app.jar

# Exponer el puerto que utiliza la aplicación (por defecto, Spring Boot usa 8080)
EXPOSE 8080

# Comando para ejecutar la aplicación cuando arranca el contenedor
ENTRYPOINT ["java", "-jar", "app.jar"]
