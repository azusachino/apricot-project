FROM amazoncorretto:17-al2-jdk AS builder
WORKDIR /app

# update the base container
RUN "apk update && apk install apache-maven"

COPY pom.xml /app/pom.xml
COPY src /app/src

RUN ["mvn", "install", "-DskipTests"]


FROM amazoncorretto:17-alpine3.19-jdk

WORKDIR /app
COPY builder:/app/target/apricot-project.jar /app/app.jar

ENTRYPOINT ["entrypoint.sh"]
