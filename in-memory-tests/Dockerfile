FROM maven:3.6.0-jdk-8-alpine

#copy src folder
COPY src /app/apiframework/src/

#copy pom.xml
COPY pom.xml /app/apiframework/

#copy testng.xml file
COPY testng.xml /app/apiframework/

#copy html report
COPY reports/testreport.html /app/apiframework/reports/testreport.html

WORKDIR /app/apiframework
#Run test cases
ENTRYPOINT mvn clean test