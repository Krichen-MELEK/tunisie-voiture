package com.annonce.voiture.service.impl;

import com.annonce.voiture.dto.OwnerDto;
import com.annonce.voiture.entity.Owner;
import com.annonce.voiture.repository.OwnerRepository;
import com.annonce.voiture.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
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

    @Override
    public Optional<Owner> findByPhoneNumber(String phoneNumber) {
        return ownerRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public void preLogin(String phoneNumber) throws Exception {
        Optional<Owner> owner = findByPhoneNumber(phoneNumber);
        if (owner.isPresent()) {
            int generatedCode = getRandomNumberInts();
            System.out.println(generatedCode);
            owner.get().setPassword(new BCryptPasswordEncoder().encode(String.valueOf(generatedCode)));
            owner.get().setExpiredDatePassword(new Date(new Date().getTime() + 15 * 60 * 1000));
            owner.get().setIsValidPassword(true);
            ownerRepository.save(owner.get());
        } else {
            throw new Exception("Account not found ");
        }
    }

    public static int getRandomNumberInts() {
        Random random = new Random();
        return random.ints(10000, (100000)).findFirst().getAsInt();
    }

    @Override
    public void updateOwner(Owner owner) {
        ownerRepository.save(owner);
    }
}