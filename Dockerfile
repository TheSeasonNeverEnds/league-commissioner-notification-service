## Stage 1: Build stage
#FROM maven:3.9.6-amazoncorretto-21 AS build
#
#WORKDIR /app
#
## Copy pom.xml and download dependencies (cached layer)
#COPY pom.xml .
#RUN mvn dependency:go-offline -B
#
## Copy source code and build the fat JAR
#COPY src ./src
#RUN mvn clean package -DskipTests
#
## Stage 2: Runtime stage
#FROM amazoncorretto:21-alpine
#WORKDIR /app
#
#
## Copy only the JAR from the build stage
#COPY --from=build /app/target/*.jar app.jar
#
## Standard Spring Boot port
#EXPOSE 8080
#
#ENTRYPOINT ["java", "-jar", "app.jar"]

#-----------------------------------

# Stage 1: Build stage
FROM eclipse-temurin:21-jdk-jammy AS build
WORKDIR /app

# Copy build files (Maven example)
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
# Download dependencies first (cached if pom.xml doesn't change)
RUN ./mvnw dependency:go-offline

# Copy source and build
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Stage 2: Runtime stage
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

## Create a non-root user for security (Best practice for AWS ECS)
#RUN addgroup --system spring && adduser --system spring --ingroup spring
#USER spring:spring

# Copy only the built jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Inform ECS that the app listens on 8080
EXPOSE 8080

# Run the application with container-aware JVM flags
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-jar", "app.jar"]