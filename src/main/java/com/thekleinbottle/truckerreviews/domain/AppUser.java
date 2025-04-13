package com.thekleinbottle.truckerreviews.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class AppUser {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable=false, updatable=false)
  private Long id;

  @Column(nullable=false, unique=true)
  private String username;

  @Column(nullable=false)
  private String password, role;

  private String email, firstname, lastname;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "appuser")
  private List<Review> reviews;


  public AppUser(String username, String password, String role) {
    this.username = username;
    this.password = password;
    this.role = role;
  }

  public AppUser() {}

}
