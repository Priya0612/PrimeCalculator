
# Step 1: Use an official OpenJDK runtime base image
FROM eclipse-temurin:26-jre-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

COPY target/*.jar PrimeService-0.0.1-SNAPSHOT.jar

# Step 3: Copy the Maven wrapper and pom.xml first to cache dependencies
#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#RUN ./mvnw dependency:go-offline

# Step 4: Copy the rest of the source code and build the application
#COPY src ./src
#RUN ./mvnw clean package -DskipTests

# Step 5: Expose the port your app runs on
EXPOSE 8080

# Step 6: Command to run the compiled JAR file
CMD ["java", "-jar", "PrimeService-0.0.1-SNAPSHOT.jar"]