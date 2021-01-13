package com.annonce.voiture.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Picture {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
