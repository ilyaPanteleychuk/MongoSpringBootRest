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
public class DeclarationsData {

    @JsonProperty("position_en")
    private String positionEn;
    
    @JsonProperty("url")
    private String url;
    
    @JsonProperty("income")
    private long income;
    
    @JsonProperty("region_uk")
    private String regionUk;
    
    @JsonProperty("office_en")
    private String officeEn;
    
    @JsonProperty("position_uk")
    private String positionUk;
    
    @JsonProperty("year")
    private int year;
    
    @JsonProperty("office_uk")
    private String officeUk;
    
    @JsonProperty("region_en")
    private String regionEn;
    
    @JsonProperty("family_income")
    private long familyIncome;
    
    @Override
    public String toString() {
        return "Declarations{" +
                "positionEn='" + positionEn + '\'' +
                ", url='" + url + '\'' +
                ", income=" + income +
                ", regionUk='" + regionUk + '\'' +
                ", officeEn='" + officeEn + '\'' +
                ", positionUk='" + positionUk + '\'' +
                ", year=" + year +
                ", officeUk='" + officeUk + '\'' +
                ", regionEn='" + regionEn + '\'' +
                ", familyIncome=" + familyIncome +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeclarationsData that = (DeclarationsData) o;
        return income == that.income && year == that.year && familyIncome == that.familyIncome && Objects.equals(positionEn, that.positionEn) && Objects.equals(url, that.url) && Objects.equals(regionUk, that.regionUk) && Objects.equals(officeEn, that.officeEn) && Objects.equals(positionUk, that.positionUk) && Objects.equals(officeUk, that.officeUk) && Objects.equals(regionEn, that.regionEn);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(positionEn, url, income, regionUk, officeEn, positionUk, year, officeUk, regionEn, familyIncome);
    }
}
