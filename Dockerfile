FROM openjdk:12

WORKDIR /app

#ARG JAR_FILE
ARG JAR_FILE=algafood-api-0.0.1-SNAPSHOT.jar

COPY target/${JAR_FILE} /app/api.jar

COPY ./wait-for-it.sh /app/wait-for-it.sh 

RUN chmod +x /app/wait-for-it.sh

EXPOSE 9000

CMD ["./wait-for-it.sh", "algafood-mysql:3306", "-t", "30", "--", "java", "-jar", "api.jar"]