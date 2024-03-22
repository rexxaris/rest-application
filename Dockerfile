FROM openjdk:17-alpine
WORKDIR /app
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew bootJar
CMD ["java", "-jar", "build/libs/rest-application-0.0.1-SNAPSHOT.jar"]