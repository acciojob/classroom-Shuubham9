package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repo;

    public void addStudent(Student student) {
        repo.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        repo.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        repo.addStudentTeacherPair(student,teacher);
    }

    public Student getStudentByName(String name) {
        return repo.getStudentByName(name);
    }

    public Teacher getTeacherByName(String name) {
        return repo.getTeacherByName(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return repo.getStudentsByTeacherName(teacher);
    }

    public List<String> getAllStudents() {
        return repo.getAllStudents();
    }

    public void deleteTeacherByName(String teacher) {
        repo.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers() {
        repo.deleteAllTeachers();
    }
}
