package impl;
import dao.homeworkdao;
import db.homework;
import jdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class homeworkdao1 implements homeworkdao{
    private Connection connection = jdbc.getConnection();

    @Override
    public boolean addHomework(String title, String requirement) {

        String sql = "INSERT INTO homework (title, requirement) VALUES (?, ?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, title);
            pst.setString(2, requirement);

            pst.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<homework> getAllHomework() {
        List<homework> homeworkList = new ArrayList<>();

        String sql = "SELECT * FROM homework";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next()){
                homework homework = new homework();
                homework.setId(resultSet.getInt("id"));
                homework.setTitle(resultSet.getString("title"));
                homework.setRequirement(resultSet.getString("requirement"));
                homework.setDeadline(resultSet.getString("deadline"));

                homeworkList.add(homework);
            }

            return homeworkList;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public homework getHomeworkByTitle(String title) {

        String sql = "SELECT * FROM homework WHERE title = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, title);
            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()){
                return new homework(resultSet.getInt("id"), resultSet.getString("title"),
                        resultSet.getString("requirement"),resultSet.getString("deadline"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<homework> getHomeworkOfTeacher(int tid) {
        List<homework> homeworkList = new ArrayList<>();

        String sql = "SELECT h.id, h.title, h.requirement,h.deadline FROM homework h, assign a WHERE h.id = a.hid AND tid = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, tid);
            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next()){
                homework homework = new homework();
                homework.setId(resultSet.getInt("id"));
                homework.setTitle(resultSet.getString("title"));
                homework.setRequirement(resultSet.getString("requirement"));
                homework.setDeadline(resultSet.getString("deadline"));

                homeworkList.add(homework);
            }

            return homeworkList;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public List<homework> getHomeworkOfStudent(int sid) {
        List<homework> homeworkList = new ArrayList<>();

        String sql = "SELECT h.id, h.title, h.requirement,h.deadline FROM homework h, submit s WHERE h.id = s.hid AND sid = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, sid);
            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next()){
                homework homework = new homework();
                homework.setId(resultSet.getInt("id"));
                homework.setTitle(resultSet.getString("title"));
                homework.setRequirement(resultSet.getString("requirement"));
                homework.setDeadline(resultSet.getString("deadline"));

                homeworkList.add(homework);
            }

            return homeworkList;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }



}
