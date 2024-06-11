# build stage
FROM openjdk:21 as builder

WORKDIR /app

COPY src/ /app/src
COPY pom.xml /app/pom.xml

RUN ["mvn", "clean", "compile:native", "-DskipTests"]

# runtime container
FROM debian:buster

WORKDIR /app

COPY builder:/app/target/apricot-project /app/apricot

ENTRYPOINT ["/app/apricot"]
