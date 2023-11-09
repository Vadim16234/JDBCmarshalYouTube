package com.example.jdbcmarshalyoutube;

import com.example.jdbcmarshalyoutube.model.Student;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Student> studentList = CRUDutils.getStudentData("select * from student");
        System.out.println(studentList);

        Student student = new Student();
        student.setName("Ivan");
        student.setSurname("Ivanov");
        student.setCurs_name("C++");

        System.out.println(CRUDutils.saveStudent(student));

        System.out.println(CRUDutils.updateStudent(2, "C#"));

        CRUDutils.deleteStudent(1);

    }
}
