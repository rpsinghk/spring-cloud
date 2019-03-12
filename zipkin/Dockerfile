FROM openjdk:8-jre-alpine
VOLUME /tmp
COPY target/zipkinService.jar /zipkinService.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","zipkinService.jar"]