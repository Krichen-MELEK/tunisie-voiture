package com.annonce.voiture.dto;

import com.annonce.voiture.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private Long id;
    private String name;

    public RoleDto(Role role) {
        id = role.getId();
        name = role.getName();
    }

    public Role convert() {
        Role role = new Role();
        role.setId(id);
        role.setName(name);
        return role;
    }
}