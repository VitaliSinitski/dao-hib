package com.vitali.dao.service;

import com.vitali.dao.dao.AnimalDao;
import com.vitali.dao.mapper.AnimalMapper;
import com.vitali.dao.mapper.CreateAnimalMapper;
import com.vitali.dao.validator.CreateAnimalValidator;
import org.junit.jupiter.api.Test;

import static com.vitali.dao.util.Util.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AnimalServiceTest {

    private CreateAnimalValidator createAnimalValidator;
    private AnimalDao animalDao;
    private CreateAnimalMapper createAnimalMapper;
    private AnimalMapper animalMapper;
    private AnimalService animalService = AnimalService.getInstance();

    @Test
    void findAll() {
        assertNotNull(animalService.findAll());
    }

    @Test
    void findById() {
//        AnimalDto animalDto = getAnimalDto();
//        Integer id = animalDto.getId();
//        AnimalDto expectetResult = animalService.findById(id);
//        assertThat(animalDto).isEqualTo(expectetResult);
    }

    @Test
    void save() {
        assertNotNull(animalService.save(getCreateAnimalDto()));
    }

    @Test
    void update() {

    }

    @Test
    void delete() {
//        CreateAnimalDto createAnimalDto = getCreateAnimalDto();
//        AnimalDto animalDto = animalService.save(createAnimalDto);
//        Integer id = animalDto.getId();
//        animalService.delete(id);
//        assertEquals(1, id);
    }



}