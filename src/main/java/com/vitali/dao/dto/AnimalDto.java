package com.vitali.dao.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AnimalDto {
    Integer id;
    String name;
    Integer weight;
}
