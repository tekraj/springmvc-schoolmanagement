package com.schoolmanagement.controllers;
import com.schoolmanagement.bean.Student;
import com.schoolmanagement.dao.StudentDao;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentDao studentDao;

    public StudentController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping("")
    public String getAllStudents(Model model) {
        List<Student> students = studentDao.getAllStudents();
        model.addAttribute("students", students);
        return "student/index";
    }

    @GetMapping("/create")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/create";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Student student) {
        studentDao.createStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String showEditStudentForm(@PathVariable int id, Model model) {
        Student student = studentDao.getStudentById(id);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/edit";
        } else {
            return "redirect:/students";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student) {
        Student existingStudent = studentDao.getStudentById(id);
        if (existingStudent != null) {
            student.setId(id);
            studentDao.updateStudent(student);
        }
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentDao.deleteStudent(id);
        return "redirect:/students";
    }
}
