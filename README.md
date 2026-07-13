# PrimeCalculator
<<<<<<< HEAD
PrimeCalculator
README.md — Spring Boot REST API services with Docker & GitHub Actions
=======
README.md — Spring Boot REST API services with Docker & GitHub Actions 
>>>>>>> c553fe2f0672a315c5f007c8fc5d41f6cac84147

**🚀 Overview **

This project is a Spring Boot REST API built with Java 26, containerized using Docker. It exposes REST endpoints on port 8080, supports multiple content types (JSON, XML), and includes unit + integration tests.

**🧰 Tech Stack **

Java 26 (Temurin),Spring Boot,Maven,JUnit 5,MockMvc,Docker

**📦 Project Structure **

<<<<<<< HEAD
src/main/java → Application + Model+ Controllers + Services src/test/java → Unit + Integration Tests Dockerfile → Runtime image (Java 26 JRE) pom.xml → Maven configuration

🔧 Prerequisites

Install the following: Java 26,Maven 3.9+, Docker Desktop, Git

Verify installations: java -version, mvn -version, docker --version,git --version
=======
src/main/java → Application + Model+ Controllers + Services
src/test/java → Unit + Integration Tests 
Dockerfile → Runtime image (Java 26 JRE) pom.xml → Maven configuration

**🔧 Prerequisites**

Install the following: Java 26,Maven 3.9+, Docker Desktop, Git

**Verify installations:** java -version, mvn -version, docker --version,git --version
>>>>>>> c553fe2f0672a315c5f007c8fc5d41f6cac84147

📥 1. Clone the Repository git clone https://github.com//.git cd

🏗️ 2. Build the Project mvn clean package ***This will generate ---target/.jar

▶️ 3. Run the Application (Without Docker) mvn spring-boot:run OR java -jar target/*.jar

Check the below in you window/internet explorer API as it should be is now available at:

http://localhost:8080/primes/10

http://localhost:8080/primes/1000000

http://localhost:8080/primes/10?accept=json

http://localhost:8080/primes/10?accept=xml

<<<<<<< HEAD
****Run the JAR directly java -jar PrimeService-0.0.1-SNAPSHOT.jar
=======
****Run the JAR directly java -jar PrimeService-0.0.1-SNAPSHOT.jar
>>>>>>> c553fe2f0672a315c5f007c8fc5d41f6cac84147
