FROM openjdk:8-jre-alpine
VOLUME /tmp
COPY target/turbineService.jar /turbineService.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","turbineService.jar"]