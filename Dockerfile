FROM maven:3.8-openjdk-17

COPY . .

RUN mvn clean package

FROM ibm-semeru-runtimes:open-17-jre-centos7

COPY --from=build target/portfolioBackEndModulo8-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]