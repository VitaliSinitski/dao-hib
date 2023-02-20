package com.vitali.dao.service;

import com.vitali.dao.dto.AnimalDto;
import com.vitali.dao.dto.CreateAnimalDto;

import java.util.List;

public interface Service {

    List<AnimalDto> findAll();

    AnimalDto findById(Integer id);

    void delete(Integer id);

    void update(CreateAnimalDto createAnimalDto, Integer id);

    AnimalDto save(CreateAnimalDto createAnimalDto);

}
