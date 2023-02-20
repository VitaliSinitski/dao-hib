package com.vitali.dao.service;

import com.vitali.dao.dao.AnimalDao;
import com.vitali.dao.dto.AnimalDto;
import com.vitali.dao.dto.CreateAnimalDto;
import com.vitali.dao.entity.Animal;
import com.vitali.dao.exception.ValidationException;
import com.vitali.dao.mapper.AnimalMapper;
import com.vitali.dao.mapper.CreateAnimalMapper;
import com.vitali.dao.validator.CreateAnimalValidator;
import com.vitali.dao.validator.ValidationResult;

import java.util.List;
import java.util.stream.Collectors;

public class AnimalService implements Service {
    private static final AnimalService INSTANCE = new AnimalService();
    private final AnimalDao animalDao = AnimalDao.getInstance();
    private final AnimalMapper animalMapper = AnimalMapper.getInstance();
    private final CreateAnimalMapper createAnimalMapper = CreateAnimalMapper.getInstance();
    private final CreateAnimalValidator createAnimalValidator = CreateAnimalValidator.getInstance();

    @Override
    public List<AnimalDto> findAll() {
        return animalDao.findAll().stream()
                .map(animalMapper::mapFrom)
                .collect(Collectors.toList());
    }

    @Override
    public AnimalDto findById(Integer id) {
        return animalMapper.mapFrom(animalDao.findById(id));
    }


    @Override
    public void delete(Integer id) {
        animalDao.delete(id);
    }

    @Override
    public void update(CreateAnimalDto createAnimalDto, Integer id) {
        Animal animalEntity = createAnimalMapper.mapFrom(createAnimalDto);
        animalDao.update(animalEntity, id);
    }

    @Override
    public AnimalDto save(CreateAnimalDto createAnimalDto) {
        ValidationResult validationResult = createAnimalValidator.isValid(createAnimalDto);
        if (validationResult.hasErrors()) {
            throw new ValidationException(validationResult.getErrors());
        }

        Animal animal = createAnimalMapper.mapFrom(createAnimalDto);
        Animal animalEntity = animalDao.save(animal);
//        return animalEntity;
        return animalMapper.mapFrom(animalEntity);
    }
    public static AnimalService getInstance() {
        return INSTANCE;
    }

}
