package com.annonce.voiture.service.impl;

import com.annonce.voiture.dto.RoleDto;
import com.annonce.voiture.entity.Role;
import com.annonce.voiture.repository.RoleRepository;
import com.annonce.voiture.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleDto getPictureById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.map(RoleDto::new).orElse(null);
    }

    @Override
    public List<RoleDto> findAll() {
        return roleRepository.findAll().stream().map(RoleDto::new).collect(Collectors.toList());
    }

    @Override
    public RoleDto save(RoleDto roleDto) {
        return new RoleDto(roleRepository.save(roleDto.convert()));
    }
}