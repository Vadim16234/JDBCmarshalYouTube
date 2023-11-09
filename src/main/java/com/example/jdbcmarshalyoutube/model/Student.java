package com.example.jdbcmarshalyoutube.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private int id;
    private String name;
    private String surname;
    private String curs_name;

    public Student() {
    }

    public Student(int id, String name, String surname, String curs_name) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.curs_name = curs_name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", curs_name='" + curs_name + '\'' +
                '}';
    }
}
