# Student Course Registration & Management System

A Java Servlet-based web application for managing students, courses, and student-course registrations. This project demonstrates core Java EE concepts including Servlets, JSP, JDBC, Sessions, Cookies, RequestDispatcher, and sendRedirect.

---

## 📌 Project Overview

The **Student Course Registration & Management System** allows an Admin to:

- Login securely using credentials stored in MySQL
- View dashboard with summary counts
- Add, view, update, and delete students
- Add, view, update, and delete courses
- Register students for courses
- View and manage registrations
- Update registration status
- Delete registrations
- Logout securely

This project follows the **MVC Architecture**:

- **Servlets** → Controller
- **JSP** → View
- **DAO** → Database Access Layer
- **Model** → Data Representation
- **DBConnection** → Utility for JDBC connections

---

## 🚀 Features

### 🔐 Login Module
- Admin authentication using database credentials
- Session-based authentication
- Remember Username using Cookies
- Validation for empty fields
- Invalid login handling using RequestDispatcher

### 📊 Dashboard Module
- Welcome message
- Logged-in admin username
- Total Students count
- Total Courses count
- Total Registrations count

### 👨‍🎓 Student Management
- Add Student
- View Students
- Edit Student
- Update Student
- Delete Student
- Prevent deletion if student has registrations

### 📚 Course Management
- Add Course
- View Courses
- Edit Course
- Update Course
- Delete Course
- Prevent deletion if active registrations exist

### 📝 Registration Management
- Register student for course
- View all registrations
- Update registration status
- Delete registration
- Prevent duplicate active registrations

### 🚪 Logout
- Session invalidation
- Redirect to login page

---

## 🛠 Technologies Used

- Java 17+ (or compatible version)
- Jakarta Servlet API
- JSP
- JDBC
- MySQL
- Apache Tomcat 10+
- Maven
- Eclipse Enterprise Edition

---

## 📂 Project Structure

```text
src/main/java
└── com.studentcourse
    ├── controller
    │   ├── LoginPageServlet.java
    │   ├── LoginServlet.java
    │   ├── LogoutServlet.java
    │   ├── DashboardServlet.java
    │   ├── AddStudentServlet.java
    │   ├── ViewStudentsServlet.java
    │   ├── EditStudentServlet.java
    │   ├── UpdateStudentServlet.java
    │   ├── DeleteStudentServlet.java
    │   ├── AddCourseServlet.java
    │   ├── ViewCoursesServlet.java
    │   ├── EditCourseServlet.java
    │   ├── UpdateCourseServlet.java
    │   ├── DeleteCourseServlet.java
    │   ├── RegistrationFormServlet.java
    │   ├── ViewRegistrationsServlet.java
    │   ├── UpdateRegistrationStatusServlet.java
    │   └── DeleteRegistrationServlet.java
    │
    ├── dao
    │   ├── AdminDAO.java
    │   ├── StudentDAO.java
    │   ├── CourseDAO.java
    │   └── RegistrationDAO.java
    │
    ├── model
    │   ├── Admin.java
    │   ├── Student.java
    │   ├── Course.java
    │   └── Registration.java
    │
    └── util
        └── DBConnection.java

src/main/webapp
└── WEB-INF/views
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
