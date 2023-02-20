package com.vitali.dao.command;

import com.vitali.dao.converter.Converter;
import com.vitali.dao.dto.CreateAnimalDto;
import com.vitali.dao.exception.ValidationException;
import com.vitali.dao.service.AnimalService;
import com.vitali.dao.validator.CreateRequestValidator;
import com.vitali.dao.validator.ValidationResult;

import javax.servlet.http.HttpServletRequest;

import static com.vitali.dao.util.Constants.*;

public class CreateCommand implements CrudCommand{
    private final CreateRequestValidator createRequestValidator = CreateRequestValidator.getInstance();
    private final AnimalService animalService = AnimalService.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equals(GET)) {
            return REGISTRATION_JSP;
        } else {
            try {
                ValidationResult validationResult = createRequestValidator.isValid(request);
                if (validationResult.hasErrors()) {
                    throw new ValidationException(validationResult.getErrors());
                }
                CreateAnimalDto createAnimalDto = Converter.convert(request);
                animalService.save(createAnimalDto);
                request.setAttribute(ANIMAL_LIST, animalService.findAll());
                return LIST_JSP;
            } catch (ValidationException exception) {
                request.setAttribute(ERRORS, exception.getErrors());
                return REGISTRATION_JSP;
            }
        }
    }
}
