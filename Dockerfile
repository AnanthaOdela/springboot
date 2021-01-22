FROM openjdk:8
<<<<<<< HEAD
ADD target/student-data-0.0.1-SNAPSHOT.jar student-data-0.0.1-SNAPSHOT.jar
=======
ADD target/student-data.jar student-data.jar
>>>>>>> 60c84d4c74c781ca7790add49109083953acd6bb
EXPOSE 9090
ENTRYPOINT ["java","-jar","student-data-0.0.1-SNAPSHOT.jar"]
