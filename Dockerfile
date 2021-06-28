FROM openjdk:11
RUN mkdir /src
COPY ./target/ideaevaluator-0.0.1-SNAPSHOT.jar /src
WORKDIR /src
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ideaevaluator-0.0.1-SNAPSHOT.jar"]