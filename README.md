Scholarship MySQL-ready (Spring Boot) - Run in Eclipse as Java Application
--------------------------------------------------------------------------

1) Create the MySQL database (run in Workbench):
   CREATE DATABASE IF NOT EXISTS scholarshipdb;

2) Edit src/main/resources/application.properties and ensure the username/password match your MySQL setup.

3) Import into Eclipse:
   File -> Import -> Existing Maven Projects -> select the project folder -> Finish.

4) Wait for Maven to download dependencies. Then run the app:
   - Open src/main/java/com/example/scholarship/Application.java
   - Right-click -> Run As -> Java Application
   - If Eclipse asks "Select Java Application", pick com.example.scholarship.Application

5) Open browser: http://localhost:8080/
   - Admin login: http://localhost:8080/admin/login (default admin@example.com / admin123)

Notes:
- The project uses Spring Boot with embedded Tomcat, so you don't need to install Tomcat separately.
- Hibernate will create/update tables automatically (spring.jpa.hibernate.ddl-auto=update).
