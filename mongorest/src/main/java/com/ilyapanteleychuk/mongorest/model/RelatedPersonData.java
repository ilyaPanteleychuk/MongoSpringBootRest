package com.ilyapanteleychuk.mongorest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RelatedPersonData {
    
    @JsonProperty("relationship_type")
    private String relationshipType;
    
    @JsonProperty("relationship_type_en")
    private String relationshipTypeEn;
    
    @JsonProperty("date_established")
    private String dateEstablished;
    
    @JsonProperty("person_en")
    private String personEn;
    
    @JsonProperty("person_uk")
    private String personUk;
    
    @JsonProperty("date_confirmed")
    private String dateConfirmed;
    
    @JsonProperty("is_pep")
    private boolean isPep;
    
    @JsonProperty("date_finished")
    private String dateFinished;
    
    @Override
    public String toString() {
        return "RelatedPerson{" +
                "relationshipType='" + relationshipType + '\'' +
                ", relationshipTypeEn='" + relationshipTypeEn + '\'' +
                ", dateEstablished='" + dateEstablished + '\'' +
                ", personEn='" + personEn + '\'' +
                ", personUk='" + personUk + '\'' +
                ", dateConfirmed='" + dateConfirmed + '\'' +
                ", isPep=" + isPep +
                ", dateFinished='" + dateFinished + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelatedPersonData that = (RelatedPersonData) o;
        return isPep == that.isPep && Objects.equals(relationshipType, that.relationshipType) && Objects.equals(relationshipTypeEn, that.relationshipTypeEn) && Objects.equals(dateEstablished, that.dateEstablished) && Objects.equals(personEn, that.personEn) && Objects.equals(personUk, that.personUk) && Objects.equals(dateConfirmed, that.dateConfirmed) && Objects.equals(dateFinished, that.dateFinished);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(relationshipType, relationshipTypeEn, dateEstablished, personEn, personUk, dateConfirmed, isPep, dateFinished);
    }
}
