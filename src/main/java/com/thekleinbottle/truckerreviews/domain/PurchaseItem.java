package com.thekleinbottle.truckerreviews.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PurchaseItem {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable=false, updatable=false)
  private Long id;

  private String name, unit;
  private int quantity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="purchaseOrder")
  private PurchaseOrder purchaseOrder;

  public PurchaseItem(PurchaseOrder purchaseOrder, String name, int quantity, String unit) {
    this.purchaseOrder = purchaseOrder;
    this.name = name;
    this.quantity = quantity;
    this.unit = unit;
  }

  public PurchaseItem() {}
}
