# Use a lightweight Linux distribution as the base image
FROM openjdk:11-jre-slim as build

# Set the working directory
WORKDIR /app

# Copy the JAR file to the container
COPY target/Demo-service-1.0-SNAPSHOT.jar /app/Demo-service-1.0-SNAPSHOT.jar

# Stage for the final image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the previous stage
COPY --from=build /app/Demo-service-1.0-SNAPSHOT.jar /app/Demo-service-1.0-SNAPSHOT.jar

# Set environment variables
ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk-amd64
ENV PATH $JAVA_HOME/bin:$PATH

# information around who maintains the image
LABEL maintainer="Demoservice.com"

# Execute the application
ENTRYPOINT ["java", "-jar", "/app/Demo-service-1.0-SNAPSHOT.jar"]
