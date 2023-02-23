package com.ilyapanteleychuk.mongorest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class FamousPeopleInfoDto {
    
    public String fullName;
    boolean died;
    boolean isPep;
}
