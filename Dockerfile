# Use Amazon Corretto 17 as the base image
FROM amazoncorretto:17-alpine3.19-jdk as build

#  Copy local code to the container image
COPY . .

# Gradle build
RUN chmod +x gradlew && ./gradlew clean build  

# The above gradle build will generate the jar file named springboot-application.jar 
# under the location /build/libs/springboot-application.jar

# Expose the port that the application listens to
EXPOSE 8080

# Specify the command to run the application
CMD ["java", "-jar", "/build/libs/springboot-application.jar"]
