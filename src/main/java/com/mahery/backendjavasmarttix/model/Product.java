package com.mahery.backendjavasmarttix.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import jakarta.persistence.*;
@Entity
@Table(name = "Produits")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50)
    private String nom;

    @Column(length = 150)
    private String description;

    @Column(length = 150)
    private Integer prix;

//    public long getId() {
//        return id;
//    }
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public Integer getPrix() {
//        return prix;
//    }
//
//    public void setPrix(Integer prix) {
//        this.prix = prix;
//    }
}
