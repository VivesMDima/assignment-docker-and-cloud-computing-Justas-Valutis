FROM eclipse-temurin:23
RUN mkdir /opt/app
COPY target/Training-Subscription-0.0.1-SNAPSHOT.jar /opt/app
CMD ["java", "-jar", "/opt/app/Training-Subscription-0.0.1-SNAPSHOT.jar", "--spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration"]
