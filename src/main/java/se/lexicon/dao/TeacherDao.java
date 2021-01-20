package se.lexicon.dao;

import se.lexicon.model.Teacher;

import java.util.Collection;
import java.util.List;

public interface TeacherDao extends BasicDao<Teacher> {

    Collection<Teacher> findBySkill(String skill);

    List<Teacher> getAllTeachers();

    int size();

}
