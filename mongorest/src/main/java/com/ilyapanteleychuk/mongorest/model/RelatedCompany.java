package com.ilyapanteleychuk.mongorest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RelatedCompany {
    
    private String relationship_type_en;
    private String to_company_short_en;
    private String date_established;
    private String to_company_edrpou;
    private String to_company_founded;
    private String date_finished;
    private boolean to_company_is_state;
    private double share;
    private String date_confirmed;
    private String to_company_uk;
    private String to_company_short_uk;
    private String to_company_en;
    private String relationship_type_uk;
    

}
