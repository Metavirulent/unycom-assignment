FROM maven:3.5-jdk-8 as BUILD
COPY . /usr/uny-service
RUN mvn -f /usr/uny-service/pom.xml clean install

FROM java:8
VOLUME /temp
COPY --from=BUILD /usr/uny-service/target/uny-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
