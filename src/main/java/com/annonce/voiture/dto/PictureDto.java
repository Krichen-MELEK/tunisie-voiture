package com.annonce.voiture.dto;

import com.annonce.voiture.entity.Picture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PictureDto {
    private Long id;
    private String name;

    public PictureDto(Picture picture) {
        id = picture.getId();
        name = picture.getName();
    }

    public Picture convert() {
        Picture picture = new Picture();
        picture.setId(id);
        picture.setName(name);
        return picture;
    }
}