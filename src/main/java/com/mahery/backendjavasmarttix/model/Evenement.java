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
    private String address;

    @Column(length = 255)
    private long lieu_id;

    @Column(length = 255)
    private double longitude;

    @Column(length = 255)
    private double latitude;

    @Column
    private long prix;

    @Column(length = 255)
    private String image_path;

    @Column(length = 255)
    private String price_id;

    @Column(length = 255)
    private String event_id_stripe ;

}
