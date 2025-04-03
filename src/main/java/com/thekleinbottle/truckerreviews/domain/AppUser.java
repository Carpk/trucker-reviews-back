package com.thekleinbottle.truckerreviews.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

@Entity
public class AppUser {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable=false, updatable=false)
  private Long id;

  @Column(nullable=false, unique=true)
  private String email;

  private String firstname, lastname;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "appuser")
  private List<Review> reviews;



  public AppUser(String email, String firstname, String lastname) {
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
  }


}
