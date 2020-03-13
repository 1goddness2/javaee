package dao;

import java.util.List;
import db.teacher;

public interface teacherdao {
    boolean addTeacher(String name, String password);
    teacher getTeacher(String name);
    List<teacher> getAllTeachers();
}
