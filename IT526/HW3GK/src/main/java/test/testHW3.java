package test;

import jakarta.persistence.EntityManager;
import utility.EntityManagerUtils;
import model.*;
import java.util.ArrayList;
import java.util.List;

public class testHW3 {

    public static void main(String[] args) {

        Student student1 = new Student("Güney Kuba", "10.04.1986", "Istanbul", "Male");
        Student student2 = new Student("Şerife Çağla Kuba", "10.05.1989", "Istanbul", "Female");
        Student student3 = new Student("Elif Lidya Kuba", "25.11.2021", "Istanbul", "Female");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        Course course1 = new Course("Enterprise Java","IT526",25);
        Course course2 = new Course("Software Testing","IT538",50);
        Course course3 = new Course("OOP with Java","IT524",75);

        student1.getCourseList().add(course1);
        student1.getCourseList().add(course2);
        student2.getCourseList().add(course1);
        student2.getCourseList().add(course2);
        student2.getCourseList().add(course3);
        student3.getCourseList().add(course2);

        Instructor instructor1= new PermanentInstructor("Ahmet Demirelli","Istanbul","5321111111",20000);
        Instructor instructor2= new VisitingResearcher("Omer Kabacan","Istanbul","5322222222",500);
        Instructor instructor3= new VisitingResearcher("Koray Güney","Istanbul","5323333333",450);

        course1.setInstructor(instructor3);
        course2.setInstructor(instructor2);
        course3.setInstructor(instructor1);

        course1.setStudentList(studentList);
        course2.setStudentList(studentList);
        course3.setStudentList(studentList);

        EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student1);
            entityManager.persist(student2);
            entityManager.persist(student3);
            entityManager.persist(course1);
            entityManager.persist(course2);
            entityManager.persist(course3);
            entityManager.persist(instructor1);
            entityManager.persist(instructor2);
            entityManager.persist(instructor3);
            entityManager.getTransaction().commit();
            System.out.println("DATA SAVED...");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }

    }

}
