package com.annonce.voiture.service;

import com.annonce.voiture.dto.AdDto;

import java.util.List;

public interface AdService {
    AdDto getAdById(Long id);

    List<AdDto> findAll();

    AdDto save(AdDto adDto);
}