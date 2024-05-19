package com.mahery.backendjavasmarttix.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Table(name = "Locations")
@Getter
@Setter
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 255)
    private String nomLocation;

    @Column(length = 255)
    private String adrLocation;

    @Column
    private Integer capacityLocation;

    @Column(length = 255)
    private String longitude;

    @Column(length = 255)
    private String latitude;

    @Column(length = 255)
    private String image_profil_path;

    @Column(length = 255)
    private String image_vr_path;
}
