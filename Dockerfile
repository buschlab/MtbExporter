FROM maven:3.8.4-openjdk-11-slim as build

COPY $PWD /mtbexporter
WORKDIR /mtbexporter

RUN mvn install

FROM alpine:3.15.0

COPY --from=build /mtbexporter/target/mtbexporter-*-jar-with-dependencies.jar /app/mtbexporter.jar
CMD ["java", "-jar", "/app/mtbexporter.jar"]