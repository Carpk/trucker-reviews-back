package com.thekleinbottle.truckerreviews.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable=false, updatable=false)
  private Long id;

  @Column(nullable=false, unique=true)
  private String invoice;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
  private List<Item> items;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="department")
  private Department department;


  public void Order(String invoice) {
    this.invoice = invoice;
  }

}
