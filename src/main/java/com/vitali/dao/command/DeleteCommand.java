package com.vitali.dao.command;

import com.vitali.dao.service.AnimalService;

import javax.servlet.http.HttpServletRequest;

import static com.vitali.dao.util.Constants.*;

public class DeleteCommand implements CrudCommand{
    private final AnimalService animalService = AnimalService.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter(ID));
        animalService.delete(id);
        request.setAttribute(ANIMAL_LIST, animalService.findAll());
        return LIST_JSP;
    }
}
