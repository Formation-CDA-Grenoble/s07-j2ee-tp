package com.example.s07j2eetp.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Section {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "grade")
    private int grade;

    @OneToMany(mappedBy = "section")
    private Set<Student> students;

    public Set<Student> getStudents() {
    	return this.students;
    }
    public void setStudents(Set<Student> students) {
    	this.students = students;
    }

    public int getGrade() {
    	return this.grade;
    }
    public void setGrade(int grade) {
    	this.grade = grade;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
    	return this.id;
    }
    public void setId(long id) {
    	this.id = id;
    }

}