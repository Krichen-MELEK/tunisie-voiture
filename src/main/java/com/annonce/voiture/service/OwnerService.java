package com.annonce.voiture.service;

import com.annonce.voiture.dto.OwnerDto;
import com.annonce.voiture.entity.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {
    OwnerDto getPictureById(Long id);

    List<OwnerDto> findAll();

    OwnerDto save(OwnerDto ownerDto);

    Optional<Owner> findByPhoneNumber(String phoneNumber);

    void preLogin(String phoneNumber) throws Exception;

    void updateOwner(Owner owner);
}