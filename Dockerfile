FROM amazoncorretto:18-alpine-jdk
MAINTAINER alejandro
COPY backend/alejandro/target/alejandro-0.0.1-SNAPSHOT.jar alejandro-app.jar
ENTRYPOINT ["java","-jar","alejandro-app.jar"]