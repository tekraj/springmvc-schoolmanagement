package com.schoolmanagement.dao;

import com.schoolmanagement.bean.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDao {

    private JdbcTemplate jdbcTemplate;

    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createStudent(Student student) {
        String query = "INSERT INTO students (id, name, grade, rollNumber, dateOfBirth, address, gender) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, student.getId(), student.getName(), student.getGrade(), student.getRollNumber(),
                student.getDateOfBirth(), student.getAddress(), student.getGender());
    }

    public Student getStudentById(int id) {
        String query = "SELECT * FROM students WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new StudentMapper());
    }

    public List<Student> getAllStudents() {
        String query = "SELECT * FROM students";
        return jdbcTemplate.query(query, new StudentMapper());
    }

    public void updateStudent(Student student) {
        String query = "UPDATE students SET name = ?, grade = ?, rollNumber = ?, dateOfBirth = ?, address = ?, gender = ? WHERE id = ?";
        jdbcTemplate.update(query, student.getName(), student.getGrade(), student.getRollNumber(), student.getDateOfBirth(),
                student.getAddress(), student.getGender(), student.getId());
    }

    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id = ?";
        jdbcTemplate.update(query, id);
    }

    private static class StudentMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setGrade(resultSet.getInt("grade"));
            student.setRollNumber(resultSet.getInt("rollNumber"));
            student.setDateOfBirth(resultSet.getDate("dateOfBirth"));
            student.setAddress(resultSet.getString("address"));
            student.setGender(resultSet.getString("gender"));
            return student;
        }
    }
}