package impl;
import dao.studentdao;
import db.student;
import jdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class studentdao1 implements studentdao{
    private Connection connection = jdbc.getConnection();

    @Override
    public boolean addStudent(String name, String password) {
        String sql = "INSERT INTO student (name, password) VALUES (?, ?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, password);

            pst.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public student getStudent(String name) {
        String sql = "SELECT * FROM student WHERE name = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, name);

            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()){
                student student = new student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setPassword(resultSet.getString("password"));

                return student;
            }

            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<student> getAllStudents() {
        String sql = "SELECT * FROM student";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            ResultSet resultSet = pst.executeQuery();

            List<student> students = new ArrayList<>();

            while(resultSet.next()){
                student student = new student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setPassword(resultSet.getString("password"));

                students.add(student);
            }

            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
