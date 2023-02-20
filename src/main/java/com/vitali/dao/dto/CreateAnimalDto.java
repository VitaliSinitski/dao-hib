package com.vitali.dao.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateAnimalDto {
    String name;
    Integer weight;
}
