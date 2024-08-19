FROM maven:3-eclipse-temurin-21 as build

COPY $PWD /mtbexporter
WORKDIR /mtbexporter

RUN mvn install -Dmaven.javadoc.skip=true -Dmaven.test.skip=true

FROM gcr.io/distroless/java21-debian12
COPY --from=build /mtbexporter/target/mtbexporter-*-jar-with-dependencies.jar /app/mtbexporter.jar
CMD ["/app/mtbexporter.jar"]