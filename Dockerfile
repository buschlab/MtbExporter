FROM maven:3-eclipse-temurin-21 as build

COPY $PWD /mtbexporter
WORKDIR /mtbexporter

RUN mvn install -Dmaven.javadoc.skip=true -Dmaven.test.skip=true

FROM gcr.io/distroless/java-base-debian12:latest

COPY --from=build /mtbexporter/target/mtbexporter-*-jar-with-dependencies.jar /app/mtbexporter.jar
ENTRYPOINT ["java", "-jar", "/app/mtbexporter.jar"]