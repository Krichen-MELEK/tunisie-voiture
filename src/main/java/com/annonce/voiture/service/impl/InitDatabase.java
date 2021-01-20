package com.annonce.voiture.service.impl;

import com.annonce.voiture.entity.Ad;
import com.annonce.voiture.entity.Owner;
import com.annonce.voiture.entity.Picture;
import com.annonce.voiture.entity.Role;
import com.annonce.voiture.repository.AdRepository;
import com.annonce.voiture.repository.OwnerRepository;
import com.annonce.voiture.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
public class InitDatabase {
    @Value("${tunisie.voiture.database.init}")
    private Boolean initDatabase;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    AdRepository adRepository;

    @PostConstruct
    public void initDatabase() {
        if (!initDatabase) return;
        // create roles
        Set<Role> roleDtoList = new HashSet<>();
        Role role = new Role(null, "Admin");
        Role role1 = new Role(null, "User");
        roleDtoList.add(role);
        roleDtoList.add(role1);
        roleRepository.saveAll(roleDtoList);

        // create users
        List<Owner> owners = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Owner owner = new Owner(null,
                    String.format("Melek_%d", i),
                    String.format("Krichen_%d", i),
                    String.format("Melek%d.Krichen_%d@gmail.com", i, i),
                    "12345678",
                    "123",
                    new HashSet<>(Collections.singletonList(role1)));
            owners.add(owner);
        }
        Owner admin = new Owner(null,
                "admin",
                "admin",
                "admin@gmail.com",
                "12345678",
                "admin",
                roleDtoList);
        owners.add(admin);
        ownerRepository.saveAll(owners);

        // create Ads
        List<Ad> ads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Ad ad = new Ad(null, "Ad title", "desc", "address", new Date(), new Date(), "registration number",
                    null, "110 km", "essence", "4 cv", "auto", "external equipments",
                    "internal equipments", "security equipments", null, owners.get(i % 100));
            Set<Picture> pictures = new HashSet<>();

            // create pictures for ad
            Picture picture = new Picture(null, String.format("%s_%s", owners.get(i % 100).getId().toString(), UUID.randomUUID().toString()));
            Picture picture1 = new Picture(null, String.format("%s_%s", owners.get(i % 100).getId().toString(), UUID.randomUUID().toString()));
            pictures.add(picture);
            pictures.add(picture1);
            ad.setPictures(pictures);
            ads.add(ad);
        }
        adRepository.saveAll(ads);
    }
}
