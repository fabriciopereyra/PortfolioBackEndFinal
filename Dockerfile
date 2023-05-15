FROM amazoncorretto:17.0.7-alpine
MAINTAINER fabriciopereyra
COPY target/portfolioBackEndModulo8-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]