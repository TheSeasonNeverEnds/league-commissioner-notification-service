# Stage 1: Build stage
FROM maven:3.9.6-amazoncorretto-21 AS build
WORKDIR /app

# Copy pom.xml and download dependencies (cached layer)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build the fat JAR
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime stage
FROM amazoncorretto:21-alpine
WORKDIR /app


# Copy only the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Standard Spring Boot port
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]