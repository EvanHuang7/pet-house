FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .

# Cache the dependency
RUN mvn dependency:go-offline -B

COPY src ./src

# Pack everything into a jar package for latter jave to run
RUN mvn clean package

FROM openjdk:21-jdk AS runner

COPY --from=builder ./app/target/billing-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 4001
EXPOSE 9001

ENTRYPOINT ["java", "-jar", "app.jar"]

