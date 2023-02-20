package com.vitali.dao.mapper;

import com.vitali.dao.dto.AnimalDto;
import com.vitali.dao.entity.Animal;

public class AnimalMapper implements Mapper<Animal, AnimalDto> {
    private static final AnimalMapper INSTANCE = new AnimalMapper();
    @Override
    public AnimalDto mapFrom(Animal object) {
        return AnimalDto.builder()
                .id(object.getId())
                .name(object.getName())
                .weight(object.getWeight())
                .build();
    }
    public static AnimalMapper getInstance() {
        return INSTANCE;
    }
}
