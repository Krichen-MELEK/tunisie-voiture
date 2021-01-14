package com.annonce.voiture.service.impl;

import com.annonce.voiture.dto.PictureDto;
import com.annonce.voiture.entity.Picture;
import com.annonce.voiture.repository.PictureRepository;
import com.annonce.voiture.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureRepository pictureRepository;

    @Override
    public PictureDto getPictureById(Long id) {
        Optional<Picture> picture = pictureRepository.findById(id);
        return picture.map(PictureDto::new).orElse(null);
    }

    @Override
    public List<PictureDto> findAll() {
        return pictureRepository.findAll().stream().map(PictureDto::new).collect(Collectors.toList());
    }

    @Override
    public PictureDto save(PictureDto pictureDto) {
        return new PictureDto(pictureRepository.save(pictureDto.convert()));
    }
}