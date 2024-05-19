package com.mahery.backendjavasmarttix.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Table(name = "evenements")
@Getter
@Setter
@NoArgsConstructor
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 255)
    private String titre_event;

    @Column(length = 255)
    private String description;

    @Column(length = 150)
    private String date;

    @Column(length = 255)
    private String lieu;

    @Column(length = 255)
    private String longitude;

    @Column(length = 255)
    private String latitude;

    @Column
    private int prix;

    @Column(length = 255)
    private String image_path;

}
