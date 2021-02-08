FROM openjdk:latest
COPY ./target/classes/com /tmp/com
WORKDIR /tmp
ENTRYPOINT ["java", "-jar","/target/seMethods-0.1.0.1-jar-with-dependencies.jar"]