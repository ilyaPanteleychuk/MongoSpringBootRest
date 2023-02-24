package com.ilyapanteleychuk.mongorest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FamousPeopleInfoDto {
    
    private String fullName;
    private boolean died;
    private boolean isPep;
}
