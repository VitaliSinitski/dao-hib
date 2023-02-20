package com.vitali.dao.validator;

import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;

import static com.vitali.dao.util.Constants.NAME;
import static com.vitali.dao.util.Constants.WEIGHT;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CreateRequestValidator implements Validator<HttpServletRequest> {

    private static final CreateRequestValidator INSTANCE = new CreateRequestValidator();

    public static CreateRequestValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public ValidationResult isValid(HttpServletRequest request) {
        ValidationResult validationResult = new ValidationResult();
        if ((request.getParameter(WEIGHT).length() == 0 || request.getParameter(WEIGHT) == null)) {
            validationResult.add(Error.of("invalid.input.weight.empty", "Введите вес! Поле должно быть заполнено"));
        }
        if ((request.getParameter(NAME).length() == 0 || request.getParameter(NAME) == null)) {
            validationResult.add(Error.of("invalid.input.name.empty", "Введите имя! Поле должно быть заполнено"));
        }
        if (request.getParameter(NAME).length() == 1){
            validationResult.add(Error.of("invalid.input.name.length", "Длина имени должна быть более одного символа"));
        }
        return validationResult;
    }

}
