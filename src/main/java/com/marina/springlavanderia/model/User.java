package com.marina.springlavanderia.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @Getter
  private String username;
  @Setter
  @Getter
  private String password;

  // Getters e setters

}
