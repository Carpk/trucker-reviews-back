package com.thekleinbottle.truckerreviews.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable=false, updatable=false)
  private Long id;

  @Column(nullable=false)
  private String title, text;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="appuser")
  private AppUser appuser;

  public Review(AppUser appuser, String title, String text) {

    this.appuser = appuser;
    this.title = title;
    this.text = text;
  }

  public Review() {}
}
