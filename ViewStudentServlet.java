package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.StudentDAO;

@WebServlet("/viewStudent")
public class ViewStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        StudentDAO dao = new StudentDAO();

        List<Student> list = dao.getAllStudents();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>View Students</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2>Student Details</h2>");

        out.println("<table border='1' cellpadding='8' cellspacing='0'>");

        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Email</th>");
        out.println("<th>Phone</th>");
        out.println("<th>Course</th>");
        out.println("<th>Address</th>");
        out.println("<th>Date of Birth</th>");
        out.println("<th>Update</th>");
        out.println("<th>Delete</th>");
        out.println("</tr>");

        for (Student s : list) {

            out.println("<tr>");

            out.println("<td>" + s.getId() + "</td>");
            out.println("<td>" + s.getName() + "</td>");
            out.println("<td>" + s.getEmail() + "</td>");
            out.println("<td>" + s.getPhone() + "</td>");
            out.println("<td>" + s.getCourse() + "</td>");
            out.println("<td>" + s.getAddress() + "</td>");
            out.println("<td>" + s.getDob() + "</td>");

            out.println("<td><a href='update?id=" + s.getId() + "'>Update</a></td>");

            out.println("<td><a href='delete?id=" + s.getId()
                    + "' onclick=\"return confirm('Are you sure?')\">Delete</a></td>");

            out.println("</tr>");
        }

        out.println("</table>");

        out.println("<br><br>");
        out.println("<a href='index.html'>Add New Student</a>");

        out.println("</body>");
        out.println("</html>");

    }
}
