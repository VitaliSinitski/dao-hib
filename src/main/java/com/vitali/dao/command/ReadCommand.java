package com.vitali.dao.command;

import com.vitali.dao.service.AnimalService;

import javax.servlet.http.HttpServletRequest;

import static com.vitali.dao.util.Constants.*;

public class ReadCommand implements CrudCommand{
    AnimalService animalService = AnimalService.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(ANIMAL_LIST, animalService.findAll());
        return LIST_JSP;
    }
}
