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
public class RelatedCompanyData {
    
    @JsonProperty("relationship_type_en")
    private String relationshipTypeEn;
    
    @JsonProperty("to_company_short_en")
    private String toCompanyShortEn;
    
    @JsonProperty("date_established")
    private String dateEstablished;
    
    @JsonProperty("to_company_edrpou")
    private String toCompanyEdrpou;
    
    @JsonProperty("to_company_founded")
    private String toCompanyFounded;
    
    @JsonProperty("date_finished")
    private String dateFinished;
    
    @JsonProperty("to_company_is_state")
    private boolean toCompanyIsState;
    
    @JsonProperty("share")
    private double share;
    
    @JsonProperty("date_confirmed")
    private String dateConfirmed;
    
    @JsonProperty("to_company_uk")
    private String toCompanyUk;
    
    @JsonProperty("to_company_short_uk")
    private String toCompanyShortUk;
    
    @JsonProperty("to_company_en")
    private String toCompanyEn;
    
    @JsonProperty("relationship_type_uk")
    private String relationshipTypeUk;
    
    @Override
    public String toString() {
        return "RelatedCompany{" +
                "relationshipTypeEn='" + relationshipTypeEn + '\'' +
                ", toCompanyShortEn='" + toCompanyShortEn + '\'' +
                ", dateEstablished='" + dateEstablished + '\'' +
                ", toCompanyEdrpou='" + toCompanyEdrpou + '\'' +
                ", toCompanyFounded='" + toCompanyFounded + '\'' +
                ", dateFinished='" + dateFinished + '\'' +
                ", toCompanyIsState=" + toCompanyIsState +
                ", share=" + share +
                ", dateConfirmed='" + dateConfirmed + '\'' +
                ", toCompanyUk='" + toCompanyUk + '\'' +
                ", toCompanyShortUk='" + toCompanyShortUk + '\'' +
                ", toCompanyEn='" + toCompanyEn + '\'' +
                ", relationshipTypeUk='" + relationshipTypeUk + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelatedCompanyData that = (RelatedCompanyData) o;
        return toCompanyIsState == that.toCompanyIsState && Double.compare(that.share, share) == 0 && Objects.equals(relationshipTypeEn, that.relationshipTypeEn) && Objects.equals(toCompanyShortEn, that.toCompanyShortEn) && Objects.equals(dateEstablished, that.dateEstablished) && Objects.equals(toCompanyEdrpou, that.toCompanyEdrpou) && Objects.equals(toCompanyFounded, that.toCompanyFounded) && Objects.equals(dateFinished, that.dateFinished) && Objects.equals(dateConfirmed, that.dateConfirmed) && Objects.equals(toCompanyUk, that.toCompanyUk) && Objects.equals(toCompanyShortUk, that.toCompanyShortUk) && Objects.equals(toCompanyEn, that.toCompanyEn) && Objects.equals(relationshipTypeUk, that.relationshipTypeUk);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(relationshipTypeEn, toCompanyShortEn, dateEstablished, toCompanyEdrpou, toCompanyFounded, dateFinished, toCompanyIsState, share, dateConfirmed, toCompanyUk, toCompanyShortUk, toCompanyEn, relationshipTypeUk);
    }
}
