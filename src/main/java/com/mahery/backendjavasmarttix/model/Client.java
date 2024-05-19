package com.mahery.backendjavasmarttix.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Clients")
@Getter
@Setter
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50)
    private String nom;

    @Column(length = 255)
    private String prenom;

    @Column(length = 255)
    private String email;

    @Column(length = 255)
    private String mots_de_passe;

}
