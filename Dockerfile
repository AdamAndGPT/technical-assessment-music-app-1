# Use a base image with Java 8 and Maven pre-installed
FROM adoptopenjdk:8-jdk-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY build/libs/music-info-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that your Spring Boot application listens on
EXPOSE 8080

# Set the command to run your Spring Boot application
CMD ["java", "-jar", "app.jar"]
