# Employee Management API

REST API for employee management built with Java, Spring Boot and MySQL.

This project provides a backend application for managing employees through a REST API, including CRUD operations, validation, exception handling and database persistence.

---

## 🚀 Technologies

- Java 23
- Spring Boot 4.1.0
- Spring Web MVC
- Spring Data JPA
- Hibernate
- MySQL 8.4
- Maven
- Docker
- Docker Compose
- Lombok
- Bean Validation

---

## 📋 Features

- List all employees
- Retrieve an employee by ID
- Create employees
- Update employees
- Delete employees
- Request validation
- Global exception handling
- MySQL persistence
- Dockerized development environment
- Environment-based database configuration

---

## 🏗️ Architecture

The backend follows a layered architecture:

```text
┌─────────────────────┐
│     Controller      │
│     REST API        │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│       Service       │
│ Business Logic      │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│     Repository      │
│    Spring Data JPA  │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│       MySQL         │
│ employee_management │
└─────────────────────┘
```
---

## 📦 Requirements

Before starting the application, install:

Docker Desktop
Git

Docker Desktop includes Docker Compose.

You do not need to install MySQL locally when using Docker.

▶️ Run the Backend with Docker
1. Clone the repository:
git clone https://github.com/FedericoBrid/EmployeeManagment.git and Move into the project directory: cd EmployeeManagment
2. Build and start the containers:
   docker compose up --build
---

## 🗄️ MySQL Configuration

Docker Compose automatically creates the MySQL database.

The default Docker configuration is:

Database:
employee_management

MySQL User:
employee

MySQL Password:
employee_password

Root Password:
root_password

MySQL Port:
3306

The backend connects to MySQL using:

jdbc:mysql://mysql:3306/employee_management

The hostname mysql is the name of the MySQL service defined in compose.yml.

---

## 🔍 Check Running Containers

1. Open another terminal and run:

docker ps

You should see containers similar to:

employee-management-db
employee-management-backend

2. You can also check the MySQL health status with:

docker inspect employee-management-db --format "{{.State.Health.Status}}"

The expected result is:

healthy

---

## ⚙️ Application Configuration

The database connection is configured through environment variables, with default values for local development.

```properties
spring.application.name=EmployeeManagment

spring.datasource.url=${BD_URL:jdbc:mysql://localhost:3306/employee_management}
spring.datasource.username=${BD_USERNAME:root}
spring.datasource.password=${BD_PASSWORD:}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---


## 🛑 Stop the Application

To stop the containers:

docker compose down

This removes the containers and network but keeps the MySQL data volume.

---


## 🔄 Start the Application Again

After the containers have been created, you can normally start the application with:

docker compose up

You only need:

docker compose up --build

when you need to rebuild the backend image, for example after changing the source code or Dockerfile.

---

## 🌐 Frontend

The React frontend is maintained in a separate repository.

Frontend repository:

https://github.com/FedericoBrid/EmployeeManagmentFrontend

The frontend communicates with this backend through:

http://localhost:8080/api/employees

The complete application architecture is:

```text
┌───────────────────────────────┐
│          React                │
│         Frontend              │
└──────────────┬────────────────┘
│
│ HTTP / REST
▼
┌───────────────────────────────┐
│        Spring Boot            │
│          Backend              │
│           :8080               │
└──────────────┬────────────────┘
│
│ JPA / JDBC
▼
┌───────────────────────────────┐
│            MySQL              │
│            :3306              │
└───────────────────────────────┘
```