FROM openjdk:8
ADD target/student-data-0.0.1-SNAPSHOT.jar student-data-0.0.1-SNAPSHOT.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","student-data-0.0.1-SNAPSHOT.jar"]
