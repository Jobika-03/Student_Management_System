package controller;

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

@WebServlet("/search")
public class SearchStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        StudentDAO dao = new StudentDAO();

        List<Student> list = dao.searchStudent(name);

        out.println("<html>");
        out.println("<head><title>Search Student</title></head>");
        out.println("<body>");

        out.println("<h2>Search Result</h2>");

        if (list.isEmpty()) {

            out.println("<h3>No Student Found!</h3>");

        } else {

            out.println("<table border='1' cellpadding='8'>");

            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Email</th>");
            out.println("<th>Phone</th>");
            out.println("<th>Course</th>");
            out.println("<th>Address</th>");
            out.println("<th>DOB</th>");
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

                out.println("</tr>");
            }

            out.println("</table>");
        }

        out.println("<br><br>");
        out.println("<a href='dashboard.html'>Dashboard</a>");

        out.println("</body>");
        out.println("</html>");
    }
}
