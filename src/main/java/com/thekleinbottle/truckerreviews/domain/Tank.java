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

  int capacity, current;

  // cap 20000 gal

  public Tank() {}
}
