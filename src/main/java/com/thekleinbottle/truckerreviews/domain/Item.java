package com.thekleinbottle.truckerreviews.domain;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable=false, updatable=false)
  private Long id;

  private String name, quantity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="order")
  private Order order;

  public void Item() {
    
  }
}
