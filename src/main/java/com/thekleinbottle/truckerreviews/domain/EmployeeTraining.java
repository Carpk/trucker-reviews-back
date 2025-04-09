package com.thekleinbottle.truckerreviews.domain;

import java.util.Date;

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
public class EmployeeTraining {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable=false, updatable=false)
  private Long id;

  String certName;
  Date completiondDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="employee")
  private Employee employee;

  public EmployeeTraining(String certName, Date date, Employee employee) {
    this.certName = certName;
    this.completiondDate = date;
    this.employee = employee;
  }

  public EmployeeTraining() {}
}
