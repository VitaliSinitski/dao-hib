package com.vitali.dao.command;

import com.vitali.dao.converter.Converter;
import com.vitali.dao.dto.AnimalDto;
import com.vitali.dao.dto.CreateAnimalDto;
import com.vitali.dao.exception.ValidationException;
import com.vitali.dao.service.AnimalService;
import com.vitali.dao.validator.CreateRequestValidator;
import com.vitali.dao.validator.ValidationResult;

import javax.servlet.http.HttpServletRequest;

import static com.vitali.dao.util.Constants.*;

public class UpdateCommand implements CrudCommand {
    private final CreateRequestValidator createRequestValidator = CreateRequestValidator.getInstance();
    AnimalService animalService = AnimalService.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter(ID));

        if (request.getMethod().equals(GET)) {
            AnimalDto animalDto = animalService.findById(id);
            request.setAttribute(ANIMAL_DTO, animalDto);
            request.setAttribute(ID, id);
            return UPDATE_JSP;
        } else {
            try {
                ValidationResult validationResult = createRequestValidator.isValid(request);
                if (validationResult.hasErrors()) {
                    throw new ValidationException(validationResult.getErrors());
                }
                CreateAnimalDto createAnimalDto = Converter.convert(request);
                animalService.update(createAnimalDto, id);
                request.setAttribute(ANIMAL_LIST, animalService.findAll());
                return LIST_JSP;
            } catch (ValidationException exception) {
                request.setAttribute(ERRORS, exception.getErrors());
                AnimalDto animalDto = animalService.findById(id);
                request.setAttribute(ANIMAL_DTO, animalDto);
                request.setAttribute(ID, id);
                return UPDATE_JSP;
            }
        }
    }
}
