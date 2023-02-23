package com.ilyapanteleychuk.mongorest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RelatedCountries {
    
    private String date_established;
    private String date_finished;
    private String date_confirmed;
    private String to_country_en;
    private String to_country_uk;
    private String relationship_type;
    
}
