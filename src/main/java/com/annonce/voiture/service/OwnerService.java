package com.annonce.voiture.service;

import com.annonce.voiture.dto.OwnerDto;

import java.util.List;

public interface OwnerService {
    OwnerDto getPictureById(Long id);

    List<OwnerDto> findAll();

    OwnerDto save(OwnerDto ownerDto);
}