# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="hectoracosta@me.com"

# Add a volume pointing to /tmp
VOLUME /tmp

EXPOSE 8080
ARG JAR_FILE=target/api_interview-0.1.0.jar
ADD ${JAR_FILE} api_interview.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/api_interview.jar"]