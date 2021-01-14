package com.annonce.voiture.service.impl;

import com.annonce.voiture.dto.OwnerDto;
import com.annonce.voiture.entity.Owner;
import com.annonce.voiture.repository.OwnerRepository;
import com.annonce.voiture.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public OwnerDto getPictureById(Long id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        return owner.map(OwnerDto::new).orElse(null);
    }

    @Override
    public List<OwnerDto> findAll() {
        return ownerRepository.findAll().stream().map(OwnerDto::new).collect(Collectors.toList());
    }

    @Override
    public OwnerDto save(OwnerDto ownerDto) {
        return new OwnerDto(ownerRepository.save(ownerDto.convert()));
    }
}