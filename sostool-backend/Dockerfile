# Build stage
FROM bellsoft/liberica-openjdk-alpine:11.0.19-7 AS build

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

COPY src ./src

RUN chmod +x mvnw
RUN ./mvnw clean package

# Run stage
FROM bellsoft/liberica-openjdk-alpine:11.0.19-7

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]