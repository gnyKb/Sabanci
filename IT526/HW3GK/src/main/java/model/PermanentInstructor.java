package model;

import jakarta.persistence.Entity;

@Entity
public class PermanentInstructor extends Instructor {

    public int fixedSalary;

    // Constructor

    public PermanentInstructor() {
    }

    public PermanentInstructor(String instructorName, String instructorAddress, String phoneNumber, int fixedSalary) {
        super(instructorName, instructorAddress, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    // Getters & Setters

    public int getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(int fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    // toString

    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "fixedSalary=" + fixedSalary +
                ", instructorID=" + instructorID +
                ", instructorName='" + instructorName + '\'' +
                ", instructorAddress='" + instructorAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", courseList=" + courseList +
                '}';
    }

}
