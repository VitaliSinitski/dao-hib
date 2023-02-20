package com.vitali.dao.mapper;

import com.vitali.dao.dto.CreateAnimalDto;
import com.vitali.dao.entity.Animal;

public class CreateAnimalMapper implements Mapper<CreateAnimalDto, Animal> {

    private final static CreateAnimalMapper INSTANCE = new CreateAnimalMapper();
    @Override
    public Animal mapFrom(CreateAnimalDto object) {
        return Animal.builder()
                .name(object.getName())
                .weight(object.getWeight())
                .build();
    }
    public static CreateAnimalMapper getInstance() {
        return INSTANCE;
    }
}
