# Usar imagen base de Java 17
FROM openjdk:17-jdk-slim

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el JAR construido a la imagen
COPY target/*.jar app.jar

# Exponer el puerto
EXPOSE 8089

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]


