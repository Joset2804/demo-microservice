FROM openjdk:8-jdk-alpine
ADD target/*.jar app.jar
ENV JAVA_OPTS=''
ENTRYPOINT [ "java", "-jar", "app.jar" ]