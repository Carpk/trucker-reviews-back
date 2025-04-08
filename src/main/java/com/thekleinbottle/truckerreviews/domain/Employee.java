package com.thekleinbottle.truckerreviews.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable=false, updatable=false)
  private Long id;

  private String firstname, lastname;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="department")
  private Department department;

  public Employee(String firstname, String lastname, Department department) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.department = department;
  }

  public Employee() {}
}
