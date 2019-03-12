FROM openjdk:8-jre-alpine
#ARG jar_file
#ARG file_name
#ENV ${file_name:-discoveryService.jar} $file_name
VOLUME /tmp
COPY target/discoveryService.jar /discoveryService.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","discoveryService.jar"]
