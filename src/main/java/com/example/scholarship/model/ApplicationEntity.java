package com.example.scholarship.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity(name = "applications")
public class ApplicationEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne private Student student;
    @ManyToOne private Scholarship scholarship;
    private LocalDate appliedDate;
    private String status;
    private String remarks;
    @PrePersist public void prePersist(){ if (appliedDate==null) appliedDate = LocalDate.now(); if (status==null) status = "Pending"; }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Student getStudent(){return student;} public void setStudent(Student s){this.student=s;}
    public Scholarship getScholarship(){return scholarship;} public void setScholarship(Scholarship s){this.scholarship=s;}
    public LocalDate getAppliedDate(){return appliedDate;} public void setAppliedDate(LocalDate d){this.appliedDate=d;}
    public String getStatus(){return status;} public void setStatus(String s){this.status=s;}
    public String getRemarks(){return remarks;} public void setRemarks(String r){this.remarks=r;}
}
