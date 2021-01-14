package com.annonce.voiture.service.impl;

import com.annonce.voiture.dto.AdDto;
import com.annonce.voiture.entity.Ad;
import com.annonce.voiture.repository.AdRepository;
import com.annonce.voiture.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdServiceImpl implements AdService {
    @Autowired
    private AdRepository adRepository;

    @Override
    public AdDto getAdById(Long id) {
        Optional<Ad> picture = adRepository.findById(id);
        return picture.map(AdDto::new).orElse(null);
    }

    @Override
    public List<AdDto> findAll() {
        return adRepository.findAll().stream().map(AdDto::new).collect(Collectors.toList());
    }

    @Override
    public AdDto save(AdDto adDto) {
        return new AdDto(adRepository.save(adDto.convert()));
    }
}