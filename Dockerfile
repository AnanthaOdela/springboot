FROM openjdk:8
ADD target/users-mysql.jar student-data.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","student-data.jar"]
