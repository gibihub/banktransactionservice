# Bank Transaction Service

## 📌 Overview
This **Bank Transaction Service** is a **Spring Boot** application that provides REST APIs for **secure money transfers** between user accounts. It ensures **ACID compliance**, uses **JPA best practices**, and follows **OWASP security principles**.

## 🚀 Features
- **Spring Boot REST API** for account transactions.
- **MySQL Database** integration with JPA/Hibernate.
- **ACID Transactions** using `@Transactional`.
- **Optimistic & Pessimistic Locking** for concurrency control.
- **JWT Authentication** for securing endpoints.
- **Unit & Integration Testing** using JUnit & Mockito.
- **Security Best Practices** (SQL Injection Prevention, CSRF Protection).

## 🛠️ Tech Stack
- **Java 17**
- **Spring Boot 3.2.1**
- **Spring Data JPA (Hibernate)**
- **MySQL Database**
- **Spring Security (JWT Authentication)**
- **JUnit 5 & Mockito**
- **Maven**

## 📂 Project Structure
```
├── src/main/java/com/bank/transactionservice
│   ├── controller      # REST Controllers
│   ├── service         # Business Logic
│   ├── repository      # JPA Repositories
│   ├── model           # Entities (User, Account, TransactionLog)
│   ├── security        # JWT Authentication
│   └── BankTransactionApplication.java  # Main Entry Point
└── src/test/java/com/bank/transactionservice
```

## 🛠️ Setup & Installation
### 1️⃣ **Clone the Repository**
```sh
git clone https://github.com/your-repo/bank-transaction-service.git
cd bank-transaction-service
```

### 2️⃣ **Configure Database (MySQL)**
Ensure MySQL is running and create the database:
```sql
CREATE DATABASE bank_db;
```
Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bank_db
spring.datasource.username=root
spring.datasource.password=secret
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

### 3️⃣ **Build and Run the Application**
```sh
mvn clean package
mvn spring-boot:run
```

### 4️⃣ **Test REST APIs**
#### ✅ **Transfer Money** (POST)
```sh
curl -X POST "http://localhost:8080/transactions/transfer?fromId=1&toId=2&amount=200"
```
#### ✅ **View All Transactions** (GET)
```sh
curl -X GET "http://localhost:8080/transactions"
```

## 🔐 Security Best Practices
- **SQL Injection Prevention:** Use `@Query` with `@Param`.
- **XSS Protection:** Encode user input before rendering.
- **JWT Authentication:** Secure endpoints with access tokens.

## 🧪 Running Tests
```sh
mvn test
```
Tests cover:
- **Unit Tests** for `TransactionService`
- **Mocked Database Queries** using Mockito

## 🐳 Running with Docker (Optional)
If you want to run the project in **Docker**, use:
```sh
docker-compose up --build
```

## 🎯 Next Steps
- ✅ Add **Kafka for Event-Driven Transactions**
- ✅ Implement **Circuit Breaker with Resilience4J**
- ✅ Optimize Queries for High Performance

## 👨‍💻 Contributors
- Raul Giblak(https://github.comgibihub)

## 📜 License
This project is licensed under the MIT License.
