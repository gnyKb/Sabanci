package com.example.hw4gk.controller;

import com.example.hw4gk.model.Student;
import com.example.hw4gk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student findStudentByStudentId(@PathVariable int id){
        return studentService.findStudentByStudentId(id);
    }

    @PostMapping("/students")
    public Student addNewStudent(@RequestBody Student student){
        return studentService.addNewStudent(student);
    }

    @PutMapping("/students")
    public Student updateExistingStudent(@RequestBody Student student){
        return studentService.updateExistingStudent(student);
    }

    @DeleteMapping("/students")
    public void deleteExistingStudent(@RequestBody Student student){
        studentService.deleteExistingStudent(student);
    }
}