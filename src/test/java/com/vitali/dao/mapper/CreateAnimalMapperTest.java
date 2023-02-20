package com.vitali.dao.mapper;

import com.vitali.dao.dto.CreateAnimalDto;
import com.vitali.dao.entity.Animal;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CreateAnimalMapperTest {
    private final CreateAnimalMapper mapper = CreateAnimalMapper.getInstance();

    @Test
    void mapFrom() {
        CreateAnimalDto dto = CreateAnimalDto.builder()
                .name("Jack")
                .weight(8)
                .build();

        Animal actualResult = mapper.mapFrom(dto);

        Animal expectetResult = Animal.builder()
                .name("Jack")
                .weight(8)
                .build();
        assertThat(actualResult).isEqualTo(expectetResult);
    }
}