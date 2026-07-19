🎓 Student Management System
Project Overview
Developed a web-based Student Management System using Java Servlets and JDBC.
Implemented complete CRUD (Create, Read, Update, Delete) functionality.
Followed the MVC (Model-View-Controller) architecture for better code organization.
Connected the application with MySQL database for storing and managing student records.
Deployed the project using Apache Tomcat Server.
Objective
To simplify student record management.
To provide an efficient way to add, update, delete, search, and view student information.
To understand the implementation of Java Web Technologies with database connectivity.
Technologies Used
Java
Java Servlets
JDBC
MySQL
HTML5
CSS3
Apache Tomcat
Eclipse IDE
Project Modules
1. Login Module
Admin authentication using username and password.
Session creation after successful login.
Redirects users to the dashboard.
2. Dashboard Module
Provides navigation to all project functionalities.
Includes buttons for:
Add Student
View Students
Search Student
Logout
3. Add Student Module
Accepts student details through an HTML form.
Validates input data.
Stores records into the MySQL database using JDBC.
4. View Students Module
Retrieves all student records from the database.
Displays records in an HTML table.
Shows Update and Delete options for each student.
5. Update Student Module
Retrieves student details using Student ID.
Displays existing data in an editable form.
Updates the modified information in the database.
6. Delete Student Module
Deletes a student record using Student ID.
Displays a confirmation dialog before deletion.
Refreshes the student list after successful deletion.
7. Search Student Module
Searches students by name.
Displays matching records from the database.
8. Logout Module
Invalidates the current session.
Redirects the user back to the login page.
