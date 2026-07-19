package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;
import java.io.PrintWriter;

import dao.StudentDAO;

@WebServlet("/update")
public class UpdateStudentServlet extends HttpServlet {
	   // Display Update Form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));

        StudentDAO dao = new StudentDAO();
        Student s = dao.getStudentById(id);

        if (s == null) {
            out.println("<h2>Student Not Found!</h2>");
            return;
        }

        out.println("<html>");
        out.println("<head><title>Update Student</title></head>");
        out.println("<body>");

        out.println("<h2>Update Student</h2>");

        out.println("<form action='update' method='post'>");

        out.println("Student ID:<br>");
        out.println("<input type='text' name='id' value='" + s.getId() + "' readonly><br><br>");

        out.println("Name:<br>");
        out.println("<input type='text' name='name' value='" + s.getName() + "' required><br><br>");

        out.println("Email:<br>");
        out.println("<input type='email' name='email' value='" + s.getEmail() + "' required><br><br>");

        out.println("Phone:<br>");
        out.println("<input type='text' name='phone' value='" + s.getPhone() + "' required><br><br>");

        out.println("Course:<br>");
        out.println("<input type='text' name='course' value='" + s.getCourse() + "' required><br><br>");

        out.println("Address:<br>");
        out.println("<textarea name='address'>" + s.getAddress() + "</textarea><br><br>");

        out.println("Date of Birth:<br>");
        out.println("<input type='date' name='dob' value='" + s.getDob() + "' required><br><br>");

        out.println("<input type='submit' value='Update Student'>");

        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }

    // Save Updated Data
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String course = request.getParameter("course");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");

        Student s = new Student();

        s.setId(id);
        s.setName(name);
        s.setEmail(email);
        s.setPhone(phone);
        s.setCourse(course);
        s.setAddress(address);
        s.setDob(dob);

        StudentDAO dao = new StudentDAO();

        boolean status = dao.updateStudent(s);

        if (status) {
            response.sendRedirect("viewStudent");
        } else {
            response.getWriter().println("<h2>Update Failed!</h2>");
        }
    }
}
