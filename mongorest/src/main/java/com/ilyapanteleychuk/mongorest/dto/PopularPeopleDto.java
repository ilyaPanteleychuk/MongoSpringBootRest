package com.ilyapanteleychuk.mongorest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;


@Getter
@Setter
@Builder
@Jacksonized
public class PopularPeopleDto {

    private String firstName;
    private int amount;
}
