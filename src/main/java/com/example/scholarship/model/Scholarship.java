package com.example.scholarship.model;

import jakarta.persistence.*;

@Entity
public class Scholarship {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Lob
    private String description;
    private Double amount;
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getDescription(){return description;} public void setDescription(String description){this.description=description;}
    public Double getAmount(){return amount;} public void setAmount(Double amount){this.amount=amount;}
}
