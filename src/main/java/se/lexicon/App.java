package se.lexicon;


import se.lexicon.dao.TeacherDao;
import se.lexicon.dao.TeacherDaoImpl;
import se.lexicon.model.Teacher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class App {

    public static void main(String[] args) {

        TeacherDao data = new TeacherDaoImpl();
        System.out.println("Collection size: " + data.size());


        ArrayList<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("C#");
        skills.add("Python");

        Teacher teacher1 = new Teacher("Test", 33, 10000, skills);
        data.create(teacher1);
        System.out.println("Collection size: " + data.size());
        System.out.println("--------------------------------------");
        Teacher findByTeacherCode = data.read(10000);
        System.out.println("Teacher: " + findByTeacherCode.toString());

        ArrayList<String> skills2 = new ArrayList<>();
        skills2.add("C#");
        skills2.add("Python");
        Teacher teacher2 = new Teacher("Test2", 44, 100002, skills2);
        data.create(teacher2);
        System.out.println("Collection size: " + data.size());
        System.out.println("--------------------------------------");

        Collection<Teacher> javaTeachers = data.findBySkill("Java");
        // convert collection to arraylist
        ArrayList<Teacher> javaTeacherList = new ArrayList<>(javaTeachers);

        System.out.println(javaTeacherList.toString());
        System.out.println("--------------------------------------");

        System.out.println(data.getAllTeachers());
        //data.create(null); // Exception in thread "main" java.lang.IllegalArgumentException: teacher object is null
    }


}
