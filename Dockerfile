FROM openjdk:21-jdk-buster

WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN chmod +x ./gradlew
RUN ./gradlew build -x test --no-daemon
 
EXPOSE 8080

CMD ["java", "-jar", "build/libs/sr-vecinet-api-gateway-0.0.1.jar"]