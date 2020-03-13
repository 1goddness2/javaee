package dao;
import db.homework;

import java.util.List;

public interface homeworkdao {

    boolean addHomework(String title, String requirement);

    List<homework> getAllHomework();

    homework getHomeworkByTitle(String title);

    List<homework> getHomeworkOfTeacher(int tid);

    List<homework> getHomeworkOfStudent(int sid);

}
