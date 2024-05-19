package com.mahery.backendjavasmarttix.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;


@Entity
@Table(name = "Billets")
@Getter
@Setter
@NoArgsConstructor
public class Billet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 150)
    private Integer prix;

    @Column(length = 150)
    private String disponibilité;

    @Column(length = 150)
    private Integer evenementId;
}
