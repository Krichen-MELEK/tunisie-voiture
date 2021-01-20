package com.annonce.voiture.dto;

import com.annonce.voiture.entity.Ad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdDto {
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
    private Set<PictureDto> pictures;
    private OwnerDto owner;

    public AdDto(Ad ad) {
        id = ad.getId();
        title = ad.getTitle();
        description = ad.getDescription();
        address = ad.getAddress();
        insertDate = ad.getInsertDate();
        lastUpdatedDate = ad.getLastUpdatedDate();
        registrationNumber = ad.getRegistrationNumber();
        circulationDate = ad.getCirculationDate();
        kilometers = ad.getKilometers();
        energy = ad.getEnergy();
        fiscalPower = ad.getFiscalPower();
        gearBox = ad.getGearBox();
        externalEquipment = ad.getExternalEquipment();
        internalEquipment = ad.getInternalEquipment();
        securityEquipment = ad.getSecurityEquipment();
        pictures = ad.getPictures().stream().map(PictureDto::new).collect(Collectors.toSet());
        owner = new OwnerDto(ad.getOwner());
    }

    public Ad convert() {
        Ad ad = new Ad();
        ad.setId(id);
        ad.setTitle(title);
        ad.setDescription(description);
        ad.setAddress(address);
        ad.setInsertDate(insertDate);
        ad.setLastUpdatedDate(lastUpdatedDate);
        ad.setRegistrationNumber(registrationNumber);
        ad.setCirculationDate(circulationDate);
        ad.setKilometers(kilometers);
        ad.setEnergy(energy);
        ad.setFiscalPower(fiscalPower);
        ad.setGearBox(gearBox);
        ad.setExternalEquipment(externalEquipment);
        ad.setInternalEquipment(internalEquipment);
        ad.setSecurityEquipment(securityEquipment);
        ad.setPictures(pictures.stream().map(PictureDto::convert).collect(Collectors.toSet()));
        ad.setOwner(owner.convert());
        return ad;
    }
}