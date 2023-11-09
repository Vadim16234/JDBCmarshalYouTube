package com.example.jdbcmarshalyoutube;

import com.example.jdbcmarshalyoutube.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDutils {
    private static String INSERT_STUDENT = "insert into student(name, surname, course_name) VALUES (?,?,?);";
    private static String UPDATE_STUDENT = "update student s set course_name = ? where id = ?";
    private static String DELETE_STUDENT = "delete from student where id = ?";

    public static List<Student> getStudentData(String qwerty) {
        List<Student> students = new ArrayList<>();

        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(qwerty)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String course_name = resultSet.getString("course_name");

                students.add(new Student(id, name, surname, course_name));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public static List<Student> saveStudent(Student student) {
        List<Student> students = new ArrayList<>();

        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getCurs_name());
            preparedStatement.executeUpdate();

            PreparedStatement allStudent = connection.prepareStatement("SELECT * from student");
            ResultSet resultSet = allStudent.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String course_name = resultSet.getString("course_name");

                students.add(new Student(id, name, surname, course_name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public static List<Student> updateStudent(int studentId, String courseName) {
        List<Student> updateStudents = new ArrayList<>();

        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT)) {
            preparedStatement.setString(1, courseName);
            preparedStatement.setInt(2, studentId);
            preparedStatement.executeUpdate();

            PreparedStatement allStudent = connection.prepareStatement("SELECT * from student");
            ResultSet resultSet = allStudent.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String course_name = resultSet.getString("course_name");

                updateStudents.add(new Student(id, name, surname, course_name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return updateStudents;
    }

    public static void deleteStudent(int studentID) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT)) {
            preparedStatement.setInt(1, studentID);
            preparedStatement.executeUpdate();

            PreparedStatement allStudent = connection.prepareStatement("SELECT * from student");
            ResultSet resultSet = allStudent.executeQuery();

            System.out.println(getStudentData("SELECT * from student"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
