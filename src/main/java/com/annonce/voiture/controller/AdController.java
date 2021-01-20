package com.annonce.voiture.controller;

import com.annonce.voiture.dto.AdDto;
import com.annonce.voiture.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ad")
public class AdController {
    @Autowired
    private AdService adService;

    @GetMapping("/{id}")
    public AdDto findById(@PathVariable Long id) {
        return adService.getAdById(id);
    }

    @GetMapping("/all")
    public List<AdDto> findAll() {
        return adService.findAll();
    }
}