FROM eclipse-temurin:21-jdk-jammy

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

#descrive la porta su cui eseguire il container
EXPOSE 3050

ENTRYPOINT ["java","-jar","/app.jar"]

##docker build -t meteoapi .

##docker run -p 3050:8080 meteoapi
