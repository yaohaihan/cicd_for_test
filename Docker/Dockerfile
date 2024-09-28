FROM openjdk:17-jdk-bullseye
EXPOSE 8080

WORKDIR /root

RUN apt-get update && \
    apt-get install -y maven

COPY target/demo*.jar /root/app.jar
ENTRYPOINT ["java","-jar","/root/app.jar"]



