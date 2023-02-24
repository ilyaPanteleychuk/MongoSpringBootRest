package com.ilyapanteleychuk.mongorest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RelatedCountriesData {
    
    @JsonProperty("date_established")
    private String dateEstablished;
    
    @JsonProperty("date_finished")
    private String dateFinished;
    
    @JsonProperty("date_confirmed")
    private String dateConfirmed;
    
    @JsonProperty("to_country_en")
    private String toCountryEn;
    
    @JsonProperty("to_country_uk")
    private String toCountryUk;
    
    @JsonProperty("relationship_type")
    private String relationshipType;
    
    @Override
    public String toString() {
        return "RelatedCountries{" +
                "dateEstablished='" + dateEstablished + '\'' +
                ", dateFinished='" + dateFinished + '\'' +
                ", dateConfirmed='" + dateConfirmed + '\'' +
                ", toCountryEn='" + toCountryEn + '\'' +
                ", toCountryUk='" + toCountryUk + '\'' +
                ", relationshipType='" + relationshipType + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelatedCountriesData that = (RelatedCountriesData) o;
        return Objects.equals(dateEstablished, that.dateEstablished) && Objects.equals(dateFinished, that.dateFinished) && Objects.equals(dateConfirmed, that.dateConfirmed) && Objects.equals(toCountryEn, that.toCountryEn) && Objects.equals(toCountryUk, that.toCountryUk) && Objects.equals(relationshipType, that.relationshipType);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(dateEstablished, dateFinished, dateConfirmed, toCountryEn, toCountryUk, relationshipType);
    }
}
