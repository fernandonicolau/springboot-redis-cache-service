# Build stage
FROM maven:3.9.9-eclipse-temurin-17-alpine AS build
COPY src /home/app/src
COPY pom.xml /home/app
COPY .env /home/app
RUN mvn -f /home/app/pom.xml clean test package

# Run stage
FROM openjdk:17-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY --from=build /home/app/target/*.jar springbootrediscacheservice.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar springbootrediscacheservice.jar
