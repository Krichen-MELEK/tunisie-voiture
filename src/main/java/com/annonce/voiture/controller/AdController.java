package com.annonce.voiture.controller;

import com.annonce.voiture.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ad")
public class AdController {
    @Autowired
    private AdService adService;

    @GetMapping("/{id}")
    public void findById(@PathVariable Long id) {
        adService.getAdById(id);
    }

    @GetMapping("/all")
    public void findAll() {
        adService.findAll();
    }
}