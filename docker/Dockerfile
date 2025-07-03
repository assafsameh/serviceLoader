# ✅ Use Maven with Java 21 base image
FROM maven:3.9.6-eclipse-temurin-21 as builder

# ✅ Set working directory
WORKDIR /app


# ✅ Copy only pom.xml and download dependencies (better layer caching)
COPY pom.xml .
RUN mvn -B dependency:go-offline


# ✅ Optional: Run tests during build for early validation (comment out in CI/CD)
# RUN mvn -B clean test


# ✅ Copy the rest of the source code
COPY . .


# ✅ Set default entrypoint and CMD
ENTRYPOINT ["mvn"]
CMD ["clean", "test", "-Dallure.results.directory=allure-results"]