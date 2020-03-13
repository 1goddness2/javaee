package dao;

import java.util.List;
import db.student;

public interface studentdao {
    boolean addStudent(String name, String password);
    student getStudent(String name);
    List<student> getAllStudents();
}
