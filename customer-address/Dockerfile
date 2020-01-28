# Alpine because it's lighter
FROM openjdk:8-jdk-alpine
MAINTAINER Ibrahim Abdllahi <ibrahim.abdullahi.external@atos.net >

# Set ENV variables
ENV PORT=8081

# Add JAR file and run it as entrypoint

ADD target/customer-address-0.0.1-SNAPSHOT.jar /home/
CMD ["java","-jar","/home/customer-address-0.0.1-SNAPSHOT.jar"]

# Expose the port
EXPOSE 8081
