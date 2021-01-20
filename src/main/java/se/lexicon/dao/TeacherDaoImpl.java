package se.lexicon.dao;

import se.lexicon.model.Teacher;

import java.util.*;

public class TeacherDaoImpl implements TeacherDao {

    private Collection<Teacher> teachers = new HashSet<>();

    @Override
    public Teacher create(Teacher teacher) {
        if (teacher == null) {
            throw new IllegalArgumentException("teacher object is null");
        }
        Teacher checkTeacher = read(teacher.getTeacherCode());
        if (checkTeacher != null) {
            throw new IllegalArgumentException("cannot add duplicate teacher code");
        }
        teachers.add(teacher);
        return teacher;
    }

    @Override
    public Teacher read(int id) {
        // 1. check or validate input parameter
        if (id <= 0) {
            throw new IllegalArgumentException("id is not valid");
        }
        Teacher result = null;
        for (Teacher teacher : teachers) {
            // if condition
            if (teacher.getTeacherCode() == id) {
                result = teacher;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean delete(Teacher teacher) {
        boolean isDelete = false;
        Iterator<Teacher> iterator = teachers.iterator();
        while (iterator.hasNext()) {
            Teacher result = iterator.next();
            if (result.equals(teacher)) {
                iterator.remove();
                isDelete = true;
            }
        }
        return isDelete;
    }

    @Override
    public boolean delete(int id) {
        // todo: delete by id + iterator
        return false;
    }

    @Override
    public Collection<Teacher> findBySkill(String skill) {
        List<Teacher> result = new ArrayList<>();
        for (Teacher teacher : teachers) {
            for (String sk : teacher.getSkills()) {
                if (sk.equalsIgnoreCase(skill)) {
                    result.add(teacher);
                }
            }
        }
        return result;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return new ArrayList<>(teachers);
    }



    @Override
    public int size() {
        return teachers.size();
    }
}
