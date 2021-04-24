package com.annonce.voiture.controller;

import com.annonce.voiture.dto.OwnerDto;
import com.annonce.voiture.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('OWNER')")
    public List<OwnerDto> findAll() {
        return ownerService.findAll();
    }
}