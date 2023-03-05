package com.example.hw4gk.service;

import com.example.hw4gk.model.Student;
import com.example.hw4gk.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addNewStudent(Student student) {

        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateExistingStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteExistingStudent(Student student) {
        studentRepository.delete(student);
    }
    public Student findStudentByStudentId(int id){
        Student student=studentRepository.findStudentByStudentId(id);
        return student;
    }
}