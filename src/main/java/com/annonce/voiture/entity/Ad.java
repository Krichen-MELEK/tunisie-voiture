package com.annonce.voiture.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String address;
    private Date insertDate;
    private Date lastUpdatedDate;
    private String registrationNumber;
    private Date circulationDate;
    private String kilometers;
    private String energy;
    private String fiscalPower;
    private String gearBox;
    private String externalEquipment;
    private String internalEquipment;
    private String securityEquipment;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Picture> pictures;
    @ManyToOne()
    @JoinColumn(nullable = false)
    private Owner owner;
}
