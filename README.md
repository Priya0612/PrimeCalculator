# PrimeCalculator

=======
README.md — Spring Boot REST API services with Docker & GitHub Actions 


**🚀 Overview and Project Requisites**

This is a RESTful service which calculates and returns all the prime numbers up to and including a number provided.

This project is written in  

-Java 26 

-Using Springboot Framework with Embedded Tomcat

-Maven Build 

-containerized using Docker. 

-It exposes REST endpoints on port 8080, 

-Supports multiple content types (JSON, XML), 

-Includes Unit + Integration tests

-Is Accessible from GitHub (Public repository)

-supports 2 algorithms that gets auto picked based on input limit.

        -- from 1 to 1000000 (uses sieveOfEratosthenes)

        -- above 1000000 (uses TrialDivisionRange)

- Spring Boot Actuator enabled to give application production‑ready monitoring, diagnostics, and management features. 

- It exposes a rich set of HTTP endpoints under /actuator to inspect and control the internal state of your running Spring Boot application

**🧰Output **

The REST call can be accessed via below

1. To return JSON content

    a. http://localhost:8080/primes/10

    b. http://localhost:8080/primes/10?accept=json

                {

                "Initial":  10,

                "Primes": [2,3,5,7]

                }

2. To return XML

    a. http://localhost:8080/primes/10?accept=xml

               <PrimeResponse>

               <initial>10</initial>

               <prime>

               <prime>2</prime>

               <prime>3</prime>

               <prime>5</prime>

               <prime>7</prime>

               </prime>

               </PrimeResponse>

3. To return actuator metrics

   a. http://localhost:8080/actuator/metrics/system.cpu.usage
   

**🧰 Tech Stack **

Java 26 (Temurin),Spring Boot,Maven,JUnit 5,MockMvc,Docker

**📦 Project Structure **

src/main/java → Application + Model+ Controllers + Services src/test/java → Unit + Integration Tests Dockerfile → Runtime image (Java 26 JRE) pom.xml → Maven configuration

**🔧 Prerequisites**

Install the following: Java 26,Maven 3.9+, Docker Desktop, Git

Verify installations: 
    
    java -version, mvn -version, docker --version,git --version

    src/main/java → Application + Model+ Controllers + Services

    src/test/java → Unit + Integration Tests 

    Dockerfile → Runtime image (Java 26 JRE) pom.xml → Maven configuration

**🏗️ Run the Project **

1.Build the Project(if cloned) -  mvn clean install  

2.Run the Application (Without Docker) - mvn spring-boot:run OR java -jar target/*.jar

                            OR

3.Run the JAR directly java -jar PrimeService-0.0.1-SNAPSHOT.jar by downloading from the target folder

API should be now available at:

http://localhost:8080/primes/10

http://localhost:8080/primes/1000000

http://localhost:8080/primes/10?accept=json

http://localhost:8080/primes/10?accept=xml