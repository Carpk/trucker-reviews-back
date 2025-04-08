package com.thekleinbottle.truckerreviews.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class PurchaseOrder {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable=false, updatable=false)
  private Long id;

  @Column(nullable=false, unique=true)
  private String invoice;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrder")
  private List<Item> items;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="department")
  private Department department;


  public PurchaseOrder(String invoice, Department department) {
    this.invoice = invoice;
    this.department = department;
  }

  public PurchaseOrder() {}

}
