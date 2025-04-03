package com.thekleinbottle.truckerreviews.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable=false, updatable=false)
  private Long id;

  @Column(nullable=false, unique=true)
  private String name;


  @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
  private List<Order> orders;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
  private List<Employee> employees;

  public Department(String name) {
    this.name = name;
    this.orders = null;
    this.employees = null;
  }

  public Department() {}

}
