package com.thekleinbottle.truckerreviews.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable=false, updatable=false)
  private Long id;

  private String firstname, lastname;

  private int payRate;

  private Date hireDate;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
  private List<EmployeeTraining> trainings;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="department")
  private Department department;

  public Employee(String firstname, String lastname, int payRate, 
      Date hireDate, Department department) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.payRate = payRate;
    this.hireDate = hireDate;
    this.department = department;
  }

  public Employee() {}
}
