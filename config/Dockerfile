FROM openjdk:8-jre-alpine
#ARG jar_file
#ARG file_name
#ENV ${file_name:-configService.jar} $file_name
VOLUME /tmp
COPY target/configService.jar /configService.jar
COPY ./application-config /application-config
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","configService.jar"]