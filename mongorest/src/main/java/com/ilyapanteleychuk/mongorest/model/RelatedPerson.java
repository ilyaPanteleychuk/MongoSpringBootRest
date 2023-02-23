package com.ilyapanteleychuk.mongorest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RelatedPerson {
    
    private String relationship_type;
    private String relationship_type_en;
    private String date_established;
    private String person_en;
    private String person_uk;
    private String date_confirmed;
    
    @JsonProperty("is_pep")
    private boolean is_pep;
    private String date_finished;
    
    @Override
    public String toString() {
        return "RelatedPerson{" +
                "relationship_type='" + relationship_type + '\'' +
                ", relationship_type_en='" + relationship_type_en + '\'' +
                ", date_established=" + date_established +
                ", person_en='" + person_en + '\'' +
                ", person_uk='" + person_uk + '\'' +
                ", date_confirmed=" + date_confirmed +
                ", is_pep=" + is_pep +
                ", date_finished=" + date_finished +
                '}';
    }
}
