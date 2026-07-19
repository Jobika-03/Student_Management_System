package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import util.DBCon;

public class StudentDAO {

	 public boolean addStudent(Student s) {

	        try {
	            Connection con = DBCon.DECon();

	            String sql = "INSERT INTO student VALUES(?,?,?,?,?,?,?)";

	            PreparedStatement ps = con.prepareStatement(sql);

	            ps.setInt(1, s.getId());
	            ps.setString(2, s.getName());
	            ps.setString(3, s.getEmail());
	            ps.setString(4, s.getPhone());
	            ps.setString(5, s.getCourse());
	            ps.setString(6, s.getAddress());
	            ps.setString(7, s.getDob());

	            int rows = ps.executeUpdate();

	            con.close();

	            return rows > 0;

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return false;
	    }

	    // View All Students
	    public List<Student> getAllStudents() {

	        List<Student> list = new ArrayList<>();

	        try {

	            Connection con = DBCon.DECon();

	            String sql = "SELECT * FROM student";

	            PreparedStatement ps = con.prepareStatement(sql);

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {

	                Student s = new Student();

	                s.setId(rs.getInt("id"));
	                s.setName(rs.getString("name"));
	                s.setEmail(rs.getString("email"));
	                s.setPhone(rs.getString("phone"));
	                s.setCourse(rs.getString("course"));
	                s.setAddress(rs.getString("address"));
	                s.setDob(rs.getString("dob"));

	                list.add(s);
	            }

	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }

	    // Get Student By ID
	    public Student getStudentById(int id) {

	        Student s = null;

	        try {

	            Connection con = DBCon.DECon();

	            String sql = "SELECT * FROM student WHERE id=?";

	            PreparedStatement ps = con.prepareStatement(sql);

	            ps.setInt(1, id);

	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {

	                s = new Student();

	                s.setId(rs.getInt("id"));
	                s.setName(rs.getString("name"));
	                s.setEmail(rs.getString("email"));
	                s.setPhone(rs.getString("phone"));
	                s.setCourse(rs.getString("course"));
	                s.setAddress(rs.getString("address"));
	                s.setDob(rs.getString("dob"));
	            }

	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return s;
	    }

	    // Update Student
	    public boolean updateStudent(Student s) {

	        try {

	            Connection con = DBCon.DECon();

	            String sql = "UPDATE student SET name=?,email=?,phone=?,course=?,address=?,dob=? WHERE id=?";

	            PreparedStatement ps = con.prepareStatement(sql);

	            ps.setString(1, s.getName());
	            ps.setString(2, s.getEmail());
	            ps.setString(3, s.getPhone());
	            ps.setString(4, s.getCourse());
	            ps.setString(5, s.getAddress());
	            ps.setString(6, s.getDob());
	            ps.setInt(7, s.getId());

	            int rows = ps.executeUpdate();

	            con.close();

	            return rows > 0;

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return false;
	    }

	    // Delete Student
	    public boolean deleteStudent(int id) {

	        try {

	            Connection con = DBCon.DECon();

	            String sql = "DELETE FROM student WHERE id=?";

	            PreparedStatement ps = con.prepareStatement(sql);

	            ps.setInt(1, id);

	            int rows = ps.executeUpdate();

	            con.close();

	            return rows > 0;

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return false;
	    }

	    // Search Student
	    public List<Student> searchStudent(String name) {

	        List<Student> list = new ArrayList<>();

	        try {

	            Connection con = DBCon.DECon();

	            String sql = "SELECT * FROM student WHERE name LIKE ?";

	            PreparedStatement ps = con.prepareStatement(sql);

	            ps.setString(1, "%" + name + "%");

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {

	                Student s = new Student();

	                s.setId(rs.getInt("id"));
	                s.setName(rs.getString("name"));
	                s.setEmail(rs.getString("email"));
	                s.setPhone(rs.getString("phone"));
	                s.setCourse(rs.getString("course"));
	                s.setAddress(rs.getString("address"));
	                s.setDob(rs.getString("dob"));

	                list.add(s);
	            }

	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }

}
