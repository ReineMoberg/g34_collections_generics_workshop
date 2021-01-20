package se.lexicon.model;

import java.util.*;

public class Teacher extends Person {

    private int teacherCode;
    private List<String> skills;

    public Teacher(String name, int age, int teacherCode, List<String> skills) {
        super(name, age);
        this.teacherCode = teacherCode;
        this.skills = skills;
    }

    public Teacher(int id, String name, int age, int teacherCode, List<String> skills) {
        super(id, name, age);
        this.teacherCode = teacherCode;
        this.skills = skills;
    }

    public int getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(int teacherCode) {
        this.teacherCode = teacherCode;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return teacherCode == teacher.teacherCode && Objects.equals(skills, teacher.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), teacherCode, skills);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherCode=" + teacherCode +
                ", skills=" + skills +
                '}' + " " + super.toString();
    }
}
