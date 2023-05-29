FROM openjdk:latest

EXPOSE 8081

ADD target/UserRegistrationService-0.0.1-SNAPSHOT.jar UserRegistrationService-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar" ,"UserRegistrationService-0.0.1-SNAPSHOT.jar"]