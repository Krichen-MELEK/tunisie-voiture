package com.annonce.voiture.service;

import com.annonce.voiture.dto.PictureDto;

import java.util.List;

public interface PictureService {
    PictureDto getPictureById(Long id);

    List<PictureDto> findAll();

    PictureDto save(PictureDto pictureDto);
}