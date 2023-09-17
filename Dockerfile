FROM openjdk
WORKDIR /app
COPY ./target/*.war /app.war
CMD ["java", "-war","app.war" ]