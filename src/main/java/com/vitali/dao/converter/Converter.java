package com.vitali.dao.converter;

import com.vitali.dao.dto.CreateAnimalDto;

import javax.servlet.http.HttpServletRequest;

import static com.vitali.dao.util.Constants.NAME;
import static com.vitali.dao.util.Constants.WEIGHT;

public class Converter {
    public static CreateAnimalDto convert(HttpServletRequest request) {
        return CreateAnimalDto.builder()
                .name(request.getParameter(NAME))
                .weight(Integer.valueOf(request.getParameter(WEIGHT)))
                .build();
    }
}
