package com.annonce.voiture.dto;

import com.annonce.voiture.entity.Owner;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class OwnerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Set<RoleDto> roles;

    public OwnerDto(Owner owner) {
        id = owner.getId();
        firstName = owner.getFirstName();
        lastName = owner.getLastName();
        email = owner.getEmail();
        phoneNumber = owner.getPhoneNumber();
        roles = owner.getRoles().stream().map(RoleDto::new).collect(Collectors.toSet());
    }

    public Owner convert() {
        Owner owner = new Owner();
        owner.setId(id);
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        owner.setEmail(email);
        owner.setPhoneNumber(phoneNumber);
        owner.setRoles(roles.stream().map(RoleDto::convert).collect(Collectors.toSet()));
        return owner;
    }
}