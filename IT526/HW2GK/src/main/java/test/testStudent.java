package test;

import jakarta.persistence.*;
import model.School;
import model.Student;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class testStudent {

    public static void main(String[] args) {

        School school1 = new School("Bogazici University", "Istanbul");
        School school2 = new School("Odtu University", "Ankara");
        School school3 = new School("Bilkent University", "Ankara");
        School school4 = new School("Ege University", "Izmir");
        Student student1 = new Student("Guney", "Kuba", 36);
        Student student2 = new Student("Hasan Furkan", "Coskun", 23);
        Student student3 = new Student("Ferhat", "Tuncel", 35);
        Student student4 = new Student("Caner", "Eminogullari", 36);
        Student student5 = new Student("Yusuf Islam", "Tuncer", 23);
        student1.setSchool(school1);
        student2.setSchool(school2);
        student3.setSchool(school3);
        student4.setSchool(school1);
        student5.setSchool(school2);

        List<School> schoolList = new ArrayList<>();
        schoolList.add(school1);
        schoolList.add(school2);
        schoolList.add(school3);
        schoolList.add(school4);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        EntityManagerFactory emf = createEntityManagerFactory("mysqlPU");
        EntityManager entityManager = emf.createEntityManager();

        saveSchools(schoolList, entityManager);
        saveStudents(studentList, entityManager);
        deleteStudent(entityManager, student5);
        deleteSchool(entityManager, school4);
        findAllStudents(entityManager);
        findAllSchools(entityManager);
        findStudentByLastName(entityManager, "Kuba");
        updateAge(entityManager, student1, 27);

    }

    private static void findAllSchools(EntityManager entityManager) {
            TypedQuery schoolJpql = entityManager.createQuery("FROM School s", School.class);
            List<School> schoolList = schoolJpql.getResultList();

            for (School school : schoolList) {
                System.out.println(school);
            }
    }

    private static void findStudentByLastName(EntityManager entityManager, String lastName) {
        TypedQuery<Student> studentJpql = entityManager.createQuery("FROM Student s WHERE s.lastName = :strName", Student.class);
        studentJpql.setParameter("strName", lastName);
        Student foundStore = studentJpql.getSingleResult();
    }

    private static void updateAge(EntityManager entityManager, Student updatedStudent, int newAge) {
        entityManager.getTransaction().begin();

        Student foundStudent = entityManager.createQuery("FROM Student s WHERE s.firstName = :strName", Student.class)
                .setParameter("strName", updatedStudent.getFirstName())
                .getSingleResult();
        foundStudent.setAge(newAge);
        entityManager.merge(foundStudent);

        entityManager.getTransaction().commit();
        System.out.println("Student age is updated to : " + newAge);
    }

    private static void findAllStudents(EntityManager entityManager) {
        TypedQuery storeJpql = entityManager.createQuery("FROM Student s", Student.class);
        List<Student> studentList = storeJpql.getResultList();

        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private static void saveStudents(List<Student> studentList, EntityManager entityManager) {
        for (Student student : studentList) {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        }
    }

    private static void deleteStudent(EntityManager entityManager, Student deletedStudent) {
        entityManager.getTransaction().begin();
        Student foundStudent = entityManager.createQuery("SELECT s FROM Student s WHERE s.firstName = :strName", Student.class)
                .setParameter("strName", deletedStudent.getFirstName())
                .getSingleResult();
        entityManager.remove(foundStudent);
        entityManager.getTransaction().commit();
        System.out.println("Student is deleted");
    }

    private static void saveSchools(List<School> schoolList, EntityManager entityManager) {
        for (School school : schoolList) {
            entityManager.getTransaction().begin();
            entityManager.persist(school);
            entityManager.getTransaction().commit();
        }
    }

    private static void deleteSchool(EntityManager entityManager, School deletedSchool) {
        entityManager.getTransaction().begin();
        School foundSchool = entityManager.createQuery("SELECT s FROM School s WHERE s.name = :strName", School.class)
                .setParameter("strName", deletedSchool.getName())
                .getSingleResult();
        entityManager.remove(foundSchool);
        entityManager.getTransaction().commit();
        System.out.println("School is deleted");
    }

}
