package model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructorID")
    public long instructorID;
    public String instructorName;
    public String instructorAddress;
    public String phoneNumber;

    @OneToMany(mappedBy = "instructor")
    public List<Course> courseList = new ArrayList<>();

    // Constructor

    public Instructor() {
    }

    public Instructor(String instructorName, String instructorAddress, String phoneNumber) {
        this.instructorName = instructorName;
        this.instructorAddress = instructorAddress;
        this.phoneNumber = phoneNumber;
    }

    // Getter & Setters

    public long getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(long instructorID) {
        this.instructorID = instructorID;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorAddress() {
        return instructorAddress;
    }

    public void setInstructorAddress(String instructorAddress) {
        this.instructorAddress = instructorAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    // toString

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorID=" + instructorID +
                ", instructorName='" + instructorName + '\'' +
                ", instructorAddress='" + instructorAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
