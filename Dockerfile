# Use Amazon Corretto 17 as the base image
FROM amazoncorretto:17-alpine3.19-jdk as build

# Set the working directory in the container
WORKDIR /app

#  Copy local code to the container image
COPY . /app/

# Gradle build
RUN chmod +x gradlew && ./gradlew build  

# The above gradle build will generate the jar file named springboot-application.jar 
# under the location /build/libs/springboot-application.jar

FROM amazoncorretto:17-alpine3.19-jdk
# Copy the executable JAR file from the target directory into the container
COPY --from=build /app/build/libs/springboot-application-plain.jar  /app/springboot-application.jar

# Expose the port that the application listens to
EXPOSE 8080

# Specify the command to run the application
CMD ["java", "-jar", "/app/springboot-application.jar"]
