
# Student Course Registration & Management System

A Java Servlet-based web application for managing student course registrations, built as an academic mini project to demonstrate core Java EE concepts including Servlets, JSP, JDBC, Sessions, Cookies, RequestDispatcher, and sendRedirect.

---

## Table of Contents

- [Project Overview](#project-overview)
- [Tech Stack](#tech-stack)
- [Features](#features)
- [Project Structure](#project-structure)
- [Database Setup](#database-setup)
- [How to Run](#how-to-run)
- [Validation Rules](#validation-rules)
- [Core Concepts Demonstrated](#core-concepts-demonstrated)
- [Screenshots](#screenshots)
- [Author](#author)

---

## Project Overview

This system allows an admin to log in and manage students, courses, and student-course registrations through a clean web interface. It follows an MVC-style architecture where Servlets act as Controllers, JSP pages act as Views, DAO classes handle all database logic, and Model classes represent data.

---

## Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java Servlets (Jakarta EE) |
| View | JSP (JavaServer Pages) |
| Database | MySQL |
| Database Connectivity | JDBC |
| Server | Apache Tomcat 10.x |
| IDE | Eclipse Enterprise Edition |
| Build Tool | Maven |
| Frontend | HTML, CSS, JavaScript |

---

## Features

- Admin login with session management
- Remember username using cookies
- Dashboard with live counts of students, courses, and registrations
- Full CRUD operations for Students
- Full CRUD operations for Courses
- Student-Course registration management
- Registration status update (Active / Completed / Cancelled)
- Delete restrictions — cannot delete a student enrolled in a course, cannot delete a course with active registrations
- Server-side and client-side validations on all forms
- Date validation — no future registration dates, max 1 year back-dating allowed
- Duplicate active registration prevention
- Session protection on all pages — unauthorized access redirects to login
- Logout destroys session completely
- Servlet lifecycle demonstrated (init, doGet, doPost, destroy)

---

## Project Structure

```
StudentCourseSystem/
│
├── pom.xml
│
└── src/
    └── main/
        ├── java/
        │   └── com/studentcourse/
        │       ├── controller/
        │       │   ├── LoginPageServlet.java
        │       │   ├── LoginServlet.java
        │       │   ├── LogoutServlet.java
        │       │   ├── DashboardServlet.java
        │       │   ├── AddStudentServlet.java
        │       │   ├── ViewStudentsServlet.java
        │       │   ├── EditStudentServlet.java
        │       │   ├── UpdateStudentServlet.java
        │       │   ├── DeleteStudentServlet.java
        │       │   ├── AddCourseServlet.java
        │       │   ├── ViewCoursesServlet.java
        │       │   ├── EditCourseServlet.java
        │       │   ├── UpdateCourseServlet.java
        │       │   ├── DeleteCourseServlet.java
        │       │   ├── RegistrationFormServlet.java
        │       │   ├── ViewRegistrationsServlet.java
        │       │   ├── UpdateRegistrationStatusServlet.java
        │       │   └── DeleteRegistrationServlet.java
        │       │
        │       ├── dao/
        │       │   ├── AdminDAO.java
        │       │   ├── StudentDAO.java
        │       │   ├── CourseDAO.java
        │       │   └── RegistrationDAO.java
        │       │
        │       ├── model/
        │       │   ├── Admin.java
        │       │   ├── Student.java
        │       │   ├── Course.java
        │       │   └── Registration.java
        │       │
        │       └── util/
        │           └── DBConnection.java
        │
        └── webapp/
            ├── index.jsp
            ├── css/
            │   └── style.css
            └── WEB-INF/
                ├── web.xml
                └── views/
                    ├── navbar.jsp
                    ├── login.jsp
                    ├── dashboard.jsp
                    ├── student-form.jsp
                    ├── student-list.jsp
                    ├── student-edit.jsp
                    ├── course-form.jsp
                    ├── course-list.jsp
                    ├── course-edit.jsp
                    ├── registration-form.jsp
                    ├── registration-list.jsp
                    └── error.jsp
```

---

## Database Setup

### Step 1 — Create the database and tables

Open MySQL Workbench or your MySQL CLI and run the following SQL script:

```sql
CREATE DATABASE IF NOT EXISTS student_course_db;
USE student_course_db;

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE registrations;
TRUNCATE TABLE students;
TRUNCATE TABLE courses;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE IF NOT EXISTS admin (
    admin_id   INT PRIMARY KEY AUTO_INCREMENT,
    username   VARCHAR(50)  NOT NULL UNIQUE,
    password   VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS students (
    student_id   INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(100) NOT NULL,
    email        VARCHAR(100) NOT NULL UNIQUE,
    phone        VARCHAR(15)  NOT NULL UNIQUE,
    age          INT          NOT NULL,
    city         VARCHAR(50)  NOT NULL,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CHECK (age >= 18)
);

CREATE TABLE IF NOT EXISTS courses (
    course_id    INT PRIMARY KEY AUTO_INCREMENT,
    course_name  VARCHAR(100)   NOT NULL,
    duration     VARCHAR(50)    NOT NULL,
    fees         DECIMAL(10, 2) NOT NULL,
    trainer_name VARCHAR(100)   NOT NULL,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CHECK (fees > 0)
);

CREATE TABLE IF NOT EXISTS registrations (
    registration_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id      INT          NOT NULL,
    course_id       INT          NOT NULL,
    registration_date DATE       NOT NULL,
    status          VARCHAR(20)  NOT NULL DEFAULT 'Active',
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_student FOREIGN KEY (student_id)
        REFERENCES students(student_id) ON DELETE CASCADE,
    CONSTRAINT fk_course  FOREIGN KEY (course_id)
        REFERENCES courses(course_id)  ON DELETE CASCADE
);

INSERT INTO admin (username, password)
VALUES ('admin', 'admin123');
```

### Step 2 — Default login credentials

| Username | Password |
|---|---|
| admin | admin123 |

---

## How to Run

### Prerequisites

- Java 17 or above
- Apache Tomcat 10.x
- MySQL 8.x
- Eclipse Enterprise Edition (or any IDE with Maven support)
- Maven

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/your-username/StudentCourseSystem.git
cd StudentCourseSystem
```

**2. Set up the database**

Run the SQL script above in MySQL Workbench or MySQL CLI.

**3. Update the database password**

Open `src/main/java/com/studentcourse/util/DBConnection.java` and change the password to match your MySQL setup:

```java
private static final String URL      = "jdbc:mysql://localhost:3306/student_course_db";
private static final String USERNAME = "root";
private static final String PASSWORD = "your_mysql_password"; // change this
```

**4. Import into Eclipse**

- Open Eclipse Enterprise Edition
- Go to `File → Import → Existing Maven Projects`
- Select the cloned project folder
- Click Finish

**5. Add Tomcat server**

- Go to `Window → Preferences → Server → Runtime Environments`
- Add Apache Tomcat 10.x and point it to your Tomcat installation folder

**6. Run the project**

- Right-click the project in Eclipse
- Select `Run As → Run on Server`
- Choose your Tomcat server
- Click Finish

**7. Open in browser**

```
http://localhost:8080/StudentCourseSystem/login
```

Log in with `admin` / `admin123`.

---

## Validation Rules

### Login
| Field | Rule |
|---|---|
| Username | Required, minimum 3 characters |
| Password | Required, minimum 6 characters |

### Student
| Field | Rule |
|---|---|
| Student Name | Required, letters only, 2–100 characters |
| Email | Required, valid format (name@domain.com) |
| Phone | Required, exactly 10 digits, cannot start with 0 |
| Age | Required, must be 18 or above, maximum 100 |
| City | Required, letters only |

### Course
| Field | Rule |
|---|---|
| Course Name | Required, minimum 3 characters |
| Duration | Required |
| Fees | Required, must be greater than 0, max 2 decimal places |
| Trainer Name | Required, letters and dots only (Mr./Ms. allowed) |

### Registration
| Field | Rule |
|---|---|
| Student | Must be selected from dropdown |
| Course | Must be selected from dropdown |
| Registration Date | Required, cannot be a future date, max 1 year back-dating allowed |
| Status | Must be Active, Completed, or Cancelled |
| Duplicate Rule | Same student cannot be actively registered for same course twice |

### Delete Rules
| Action | Rule |
|---|---|
| Delete Student | Blocked if student has any existing registration |
| Delete Course | Blocked if course has any Active registrations |

---

## Core Concepts Demonstrated

| Concept | Where Used |
|---|---|
| Servlet Lifecycle (init, doGet, doPost, destroy) | LoginServlet, DashboardServlet, AddStudentServlet, AddCourseServlet |
| HttpSession | Created on login, validated on every protected page, destroyed on logout |
| Cookies | Used only for remembering admin username (7-day expiry) |
| RequestDispatcher | Used for forwarding validation errors and data to JSP pages |
| sendRedirect | Used after successful login, logout, insert, update, and delete operations |
| JDBC with PreparedStatement | All database operations in DAO classes |
| CRUD Operations | Students, Courses, and Registrations modules |
| MVC Pattern | Servlet (Controller), JSP (View), DAO (Model/Database Logic) |

---

## Navigation Rules (Post-Redirect-Get Pattern)

| Situation | Technique Used |
|---|---|
| Validation error | RequestDispatcher — preserves user input |
| Invalid login | RequestDispatcher — shows error on same page |
| Display data on JSP | RequestDispatcher |
| Successful login | sendRedirect to dashboard |
| Successful insert | sendRedirect to list page |
| Successful update | sendRedirect to list page |
| Successful delete | sendRedirect to list page |
| Logout | sendRedirect to login page |
| Unauthorized access | sendRedirect to login page |

---

## Author

**Harsh Agarwal**  
Mini Project — Java Servlet Web Application  
Apache Tomcat 10.x · MySQL 8.x · Java 21 · Eclipse Enterprise Edition
