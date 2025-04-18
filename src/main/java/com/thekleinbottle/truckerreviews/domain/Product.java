package com.thekleinbottle.truckerreviews.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable=false, updatable=false)
  private Long id;

  String name;

  public Product() {
    
  }

}
