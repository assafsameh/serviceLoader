FROM maven:3.9.6-eclipse-temurin-21

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY . .

ENTRYPOINT ["mvn"]
CMD ["clean", "test", "-Dallure.results.directory=allure-results"]