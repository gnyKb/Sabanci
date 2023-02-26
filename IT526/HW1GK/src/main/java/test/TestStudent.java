package test;

import jakarta.persistence.*;
import model.Student;
import java.util.ArrayList;
import java.util.List;

public class TestStudent {
    public static void main(String[] args) {

        Student student1 = new Student("Güney", "Kuba");
        Student student2 = new Student("Ferhat", "Tuncel");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
        EntityManager entityManager = emf.createEntityManager();

        saveStudents(studentList, entityManager);

    }

    private static void saveStudents(List<Student> studentList, EntityManager entityManager) {
        for (Student student : studentList) {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        }
    }
    
}
