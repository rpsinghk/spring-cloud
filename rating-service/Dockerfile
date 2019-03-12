FROM openjdk:8-jre-alpine
#ARG jar_file
#ARG file_name
#ENV ${file_name:-gatewayService.jar} $file_name
VOLUME /tmp
COPY target/ratingService.jar /ratingService.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","ratingService.jar"]