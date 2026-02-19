🎓 Scholarship Management System

A full-stack web application built using Spring Boot, MySQL, Spring Data JPA, and Thymeleaf that enables students to register, view scholarships, and apply online, while administrators can manage and review applications.

This project demonstrates practical implementation of Spring Boot MVC architecture, database relationships, and role-based application flow.

🚀 Features
👨‍🎓 Student Module

Student Registration & Login

View Available Scholarships

Apply for Scholarships

Track Submitted Applications

👨‍💼 Admin Module

Secure Admin Login

View All Student Applications

Manage Scholarships

🛠 Tech Stack
Layer	Technology Used
Backend	Spring Boot
Frontend	Thymeleaf (Server-Side Rendering)
Database	MySQL
ORM	Spring Data JPA (Hibernate)
Build Tool	Maven
Server	Embedded Tomcat
🏗 Architecture

The project follows Spring Boot MVC Architecture:

Controller → Repository → Database

Package Structure
src/main/java/com/example/scholarship/
│
├── controller/     → Handles HTTP requests
├── model/          → JPA Entity classes
├── repo/           → JPA Repositories
└── Application.java → Main entry point


Frontend templates:

src/main/resources/templates/

🔄 Application Flow
Student Flow

Register account

Login

View scholarship list

Apply for scholarship

Application saved in database

Admin Flow

Login as admin

View all student applications

Review scholarship details

🗄 Database Design
Tables

Student

Scholarship

Application

Admin

Relationships

One Student → Many Applications

One Scholarship → Many Applications

JPA annotations are used to manage entity relationships.

⚙️ Setup & Installation
1️⃣ Clone Repository
git clone 
2️⃣ Create MySQL Database
CREATE DATABASE scholarship;
3️⃣ Configure application.properties

Update:

spring.datasource.url=jdbc:mysql://localhost:3306/scholarship
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

4️⃣ Run the Application

Using Maven:

mvn spring-boot:run


Or run Application.java from your IDE.

Application will start at:

http://localhost:8080

📚 Learning Outcomes

Through this project, the following concepts were implemented:

Spring Boot MVC

JPA Entity Relationships

MySQL Integration

Role-based application logic

Server-side rendering using Thymeleaf

CRUD operations using JpaRepository

🚧 Future Enhancements

Implement Spring Security

Add BCrypt password encryption

Add role-based authorization

Add application status (Pending/Approved/Rejected)

Add pagination and search

Convert to REST API + React frontend

Implement JWT authentication

