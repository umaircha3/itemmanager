FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=itemmanager/build/libs/itemmanager*SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]