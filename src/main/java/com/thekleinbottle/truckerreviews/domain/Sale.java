package com.thekleinbottle.truckerreviews.domain;

import jakarta.persistence.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Sale {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable=false, updatable=false)
  private Long id;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "sale")
  private List<SaleItem> items;

  public Sale() {
    
  }
}
