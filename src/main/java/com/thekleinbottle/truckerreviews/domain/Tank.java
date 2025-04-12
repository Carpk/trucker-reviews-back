package com.thekleinbottle.truckerreviews.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tank {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable=false, updatable=false)
  private Long id;

  String name;

  int capacity, current, temp, preasure;

  // cap 20000 gal

  public Tank(String name, int current, int capacity) {
    this.name = name;
    this.current = current;
    this.capacity = capacity;
  }

  public Tank() {}

  public void sell(int amount) {
    current = current - amount;
  }

  public void refill(int amount) {
    current = current + amount;
  }
}
