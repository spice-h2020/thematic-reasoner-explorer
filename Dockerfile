FROM maven:3.8.6-openjdk-11

RUN mkdir /opt/tr_explorer

COPY target/thematic-reasoner-explorer-0.0.1-SNAPSHOT.jar /opt/tr_explorer
COPY application.properties /opt/tr_explorer

WORKDIR /opt/tr_explorer

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/opt/tr_explorer/thematic-reasoner-explorer-0.0.1-SNAPSHOT.jar"]