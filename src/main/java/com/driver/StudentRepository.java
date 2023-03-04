package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<String,Student> std = new HashMap();
    Map<String,Teacher> tch = new HashMap();
    Map<String,String> studentTeacher = new HashMap();
    Map<String, List<String>> teacherAndstudents = new HashMap();

    public void addStudent(Student student) {
        std.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher) {
        tch.put(teacher.getName(),teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        studentTeacher.put(student,teacher);


            List<String> students = new ArrayList<>();

            if(teacherAndstudents.containsKey(teacher)){
                students=teacherAndstudents.get(teacher);
                students.add(student);
                teacherAndstudents.put(teacher,students);
            }
            else{
                students.add(student);
                teacherAndstudents.put(teacher,students);
            }


    }

    public Student getStudentByName(String name) {
        return std.get(name);
    }

    public Teacher getTeacherByName(String name) {
        return tch.get(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return teacherAndstudents.get(teacher);
    }

    public List<String> getAllStudents() {
        List<String> students = new ArrayList<>();
        for(String student : std.keySet()){
            students.add(student);
        }
        return students;
    }

    public void deleteTeacherByName(String teacher) {
        tch.remove(teacher);
        List<String> students = teacherAndstudents.get(teacher);

        for(String student : students){
            std.remove(student);
            studentTeacher.remove(student);
        }
        teacherAndstudents.remove(teacher);
    }

    public void deleteAllTeachers() {
        for (String student : studentTeacher.keySet()) {
            std.remove(student);
        }
        for (List<String> students : teacherAndstudents.values()) {
            for (String student: students) {
                std.remove(student);
            }
        }
        tch.clear();
        studentTeacher.clear();
        teacherAndstudents.clear();
    }
}
