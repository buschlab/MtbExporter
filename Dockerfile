FROM maven:3.8.6-openjdk-11-slim as build

COPY $PWD /mtbexporter
WORKDIR /mtbexporter

RUN mvn install -Dmaven.javadoc.skip=true -Dmaven.test.skip=true

FROM gcr.io/distroless/java11-debian11

COPY --from=build /mtbexporter/target/mtbexporter-*-jar-with-dependencies.jar /app/mtbexporter.jar
ENTRYPOINT ["java", "-jar", "/app/mtbexporter.jar"]