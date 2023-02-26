package model;

import jakarta.persistence.Entity;

@Entity
public class VisitingResearcher extends Instructor {

    public int hourlySalary;

    // Constructor

    public VisitingResearcher() {
    }

    public VisitingResearcher(String instructorName, String instructorAddress, String phoneNumber, int hourlySalary) {
        super(instructorName, instructorAddress, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    // Getters & Setters

    public int getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(int hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    // toString

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "hourlySalary=" + hourlySalary +
                ", instructorID=" + instructorID +
                ", instructorName='" + instructorName + '\'' +
                ", instructorAddress='" + instructorAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", courseList=" + courseList +
                '}';
    }

}
