FROM openjdk:11-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

# docker logout

# docker build -t subter-backend:2.0.0 .

# docker tag subter-backend:2.0.0 apidocdocker/subter-backend:2.0.0

# docker login 

# docker push apidocdocker/subter-backend:2.0.0

# docker run -p 8080:8080 subter-backend:2.0.0