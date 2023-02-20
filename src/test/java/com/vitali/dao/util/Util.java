package com.vitali.dao.util;

import com.vitali.dao.dto.AnimalDto;
import com.vitali.dao.dto.CreateAnimalDto;
import com.vitali.dao.entity.Animal;

public class Util {
    public static CreateAnimalDto getCreateAnimalDto() {
        return CreateAnimalDto.builder()
                .name("Jack")
                .weight(8)
                .build();
    }

    public static AnimalDto getAnimalDto() {
        return AnimalDto.builder()
                .id(99)
                .name("Jack")
                .weight(8)
                .build();
    }

    public static Animal getAnimal() {
        return Animal.builder()
                .id(99)
                .name("Jack")
                .weight(8)
                .build();
    }
}
