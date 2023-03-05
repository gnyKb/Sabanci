package com.example.hw4gk.initialize;

import com.example.hw4gk.model.Student;
import com.example.hw4gk.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class TestDataInitializer implements CommandLineRunner {

    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (studentRepository.count() == 0) {
            Student student1 = new Student("Güney", "Kuba", 37);
            Student student2 = new Student("Şerife Çağla", "Kuba", 34);
            Student student3 = new Student("Elif Lidya", "Kuba", 2);
            studentRepository.save(student1);
            studentRepository.save(student2);
            studentRepository.save(student3);

        }
    }
}
