package com.annonce.voiture.controller;

import com.annonce.voiture.dto.PictureDto;
import com.annonce.voiture.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @GetMapping("/all")
    public List<PictureDto> findAll() {
        return pictureService.findAll();
    }
}