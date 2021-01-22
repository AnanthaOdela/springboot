FROM openjdk:8
ADD target/student-data.jar student-data.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","student-data.jar"]
