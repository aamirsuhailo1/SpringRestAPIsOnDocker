FROM maven:3.6.0-jdk-8-alpine

#copy src folder
COPY src /app/src

#copy testng.xml file
COPY testng.xml /app/

#copy html report
COPY reports/testreport.html /app/reports/

#copy pom.xml
COPY pom.xml /app/

WORKDIR /app
#Run test cases
ENTRYPOINT mvn clean test