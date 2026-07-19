package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;

import dao.StudentDAO;

@WebServlet("/addstudent")
public class AddStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get data from HTML form
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String course = request.getParameter("course");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");

        // Create Student Object
        Student s = new Student();

        s.setId(id);
        s.setName(name);
        s.setEmail(email);
        s.setPhone(phone);
        s.setCourse(course);
        s.setAddress(address);
        s.setDob(dob);

        // Call DAO
        StudentDAO dao = new StudentDAO();

        boolean status = dao.addStudent(s);

        if(status){

            response.setContentType("text/html");

            response.getWriter().println("<h2>Student Added Successfully!</h2>");
            response.getWriter().println("<a href='index.html'>Add Another Student</a><br><br>");
            response.getWriter().println("<a href='viewStudent'>View Students</a>");

        }else{

            response.setContentType("text/html");

            response.getWriter().println("<h2>Failed to Add Student!</h2>");
            response.getWriter().println("<a href='index.html'>Try Again</a>");

        }

    }
}
