package com.pluralsight.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private long averageGrade;

    public Course(long id, String name, String description, long averageGrade) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.averageGrade = averageGrade;
    }

    public Course(){

    }

    public long getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(long averageGrade) {
        this.averageGrade = averageGrade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
