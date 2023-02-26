package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "studentID")
    public long studentID;
    public String studentName;
    public String birthDate;
    public String studentAddress;
    public String gender;

    @ManyToMany(mappedBy = "studentList")
    public List<Course> courseList = new ArrayList<>();

    // Constructors (Do not use "id" & Lists within full constructor)

    public Student() {
    }

    public Student(String studentName, String birthDate, String studentAddress, String gender) {
        this.studentName = studentName;
        this.birthDate = birthDate;
        this.studentAddress = studentAddress;
        this.gender = gender;
    }

    // Getters & Setters (for all fields)

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String name) {
        this.studentName = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String address) {
        this.studentAddress = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    // toString (without ID)

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", name='" + studentName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", address='" + studentAddress + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

}
