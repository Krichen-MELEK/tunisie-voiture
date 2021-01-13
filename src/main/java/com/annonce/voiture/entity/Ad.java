package com.annonce.voiture.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Ad {
    @Id
    @GeneratedValue
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
