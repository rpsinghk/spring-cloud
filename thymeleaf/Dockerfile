FROM openjdk:8-jre-alpine
VOLUME /tmp
COPY target/thymeleafService.jar /thymeleafService.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","thymeleafService.jar"]