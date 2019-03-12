FROM openjdk:8-jre-alpine
#ARG jar_file
#ARG file_name
#ENV ${file_name:-configService.jar} $file_name
VOLUME /tmp
COPY target/bookService.jar /bookService.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","bookService.jar"]