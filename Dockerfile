# Dockerfile
FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /workspace

# copia pom primeiro para aproveitar cache de dependências
COPY pom.xml .
COPY src ./src

RUN mvn -B -DskipTests package

FROM eclipse-temurin:17-jre
WORKDIR /app

# copia o JAR gerado pelo stage de build
COPY --from=builder /workspace/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]