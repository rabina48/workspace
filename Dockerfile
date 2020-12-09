FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/demo-0.0.1-SNAPSHOT.jar application.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","/application.jar"]