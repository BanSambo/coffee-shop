# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file to the container
COPY src/main/resources/static /app/static
COPY shop-0.0.1-SNAPSHOT.jar /app/coffee-shop.jar

# Copy the templates directory to the container
COPY src/main/resources/templates /app/templates

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "coffee-shop.jar"]