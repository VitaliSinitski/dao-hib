package com.vitali.dao.mapper;

import com.vitali.dao.dto.AnimalDto;
import com.vitali.dao.entity.Animal;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnimalMapperTest {
    private final AnimalMapper mapper = AnimalMapper.getInstance();
    @Test
    void mapFrom() {
        Animal animal = Animal.builder()
                .id(99)
                .name("Jack")
                .weight(8)
                .build();

        AnimalDto actualResult = mapper.mapFrom(animal);

        AnimalDto expectetResult = AnimalDto.builder()
                .id(99)
                .name("Jack")
                .weight(8)
                .build();
        assertThat(actualResult).isEqualTo(expectetResult);
    }
}