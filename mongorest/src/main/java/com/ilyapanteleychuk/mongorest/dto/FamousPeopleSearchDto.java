package com.ilyapanteleychuk.mongorest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class FamousPeopleSearchDto {
    
    private String firstName;
    private String lastName;
    private String patronymic;
    
    private Integer from;
    private Integer size;
    
}
