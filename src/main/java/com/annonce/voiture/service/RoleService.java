package com.annonce.voiture.service;

import com.annonce.voiture.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto getPictureById(Long id);

    List<RoleDto> findAll();

    RoleDto save(RoleDto roleDto);
}