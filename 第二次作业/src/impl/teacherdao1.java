package impl;
import dao.teacherdao;
import db.teacher;
import jdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class teacherdao1 implements teacherdao{

    private Connection connection = jdbc.getConnection();

    @Override
    public boolean addTeacher(String name, String password) {
        String sql = "INSERT INTO teacher (name, password) VALUES (?, ?)";

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
    public teacher getTeacher(String name) {
        String sql = "SELECT * FROM teacher WHERE name = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, name);

            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()){
                teacher teacher = new teacher();
                teacher.setId(resultSet.getInt("id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setPassword(resultSet.getString("password"));

                return teacher;
            }

            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<teacher> getAllTeachers() {
        String sql = "SELECT * FROM teacher";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            ResultSet resultSet = pst.executeQuery();

            List<teacher> teachers = new ArrayList<>();

            while (resultSet.next()){
                teacher teacher = new teacher();
                teacher.setId(resultSet.getInt("id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setPassword(resultSet.getString("password"));

                teachers.add(teacher);
            }

            return teachers;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
