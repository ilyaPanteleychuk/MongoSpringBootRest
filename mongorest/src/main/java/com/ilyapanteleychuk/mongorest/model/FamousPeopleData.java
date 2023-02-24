package com.ilyapanteleychuk.mongorest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

/**
 * Representation of database entity famous_people
 *
 * @author Ilya Panteleychuk
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document("famous_people")
public class FamousPeopleData {
    
    @Id
    @JsonProperty("_id")
    private String _id;
    
    @JsonProperty("first_name")
    private String firstName;
    
    @JsonProperty("last_name")
    private String lastName;
    
    @JsonProperty("full_name")
    private String fullName;
    
    @JsonProperty("patronymic")
    private String patronymic;
    
    @JsonProperty("also_known_as_uk")
    private String alsoKnownAsUk;
    
    @JsonProperty("patronymic_en")
    private String patronymicEn;
    
    @JsonProperty("full_name_en")
    private String fullNameEn;
    
    @JsonProperty("first_name_en")
    private String firstNameEn;
    
    @JsonProperty("last_name_en")
    private String lastNameEn;
    
    @JsonProperty("also_known_as_en")
    private String alsoKnownAsEn;
    
    @JsonProperty("date_of_birth")
    private String dateOfBirth;
    
    @JsonProperty("is_pep")
    private boolean isPep;
    
    @JsonProperty("died")
    private boolean died;
    
    @JsonProperty("photo")
    private String photo;
    
    @JsonProperty("city_of_birth_uk")
    private String cityOfBirthUk;
    
    @JsonProperty("city_of_birth_en")
    private String cityOfBirthEn;
    
    @JsonProperty("type_of_official")
    private String typeOfOfficial;
    
    @JsonProperty("type_of_official_en")
    private String typeOfOfficialEn;
    
    @JsonProperty("last_job_title")
    private String lastJobTitle;
    
    @JsonProperty("last_workplace")
    private String lastWorkplace;
    @JsonProperty("last_workplace_en")
    private String lastWorkplaceEn;
    
    @JsonProperty("last_job_title_en")
    private String lastJobTitleEn;
    
    @JsonProperty("reason_of_termination")
    private String reasonOfTermination;
    
    @JsonProperty("reason_of_termination_en")
    private String reasonOfTerminationEn;
    
    @JsonProperty("termination_date_human")
    private String terminationDateHuman;
    
    @JsonProperty("reputation_convictions_uk")
    private String reputationConvictionsUk;
    
    @JsonProperty("reputation_manhunt_uk")
    private String reputationManhuntUk;
    
    @JsonProperty("reputation_sanctions_uk")
    private String reputationSanctionsUk;
    
    @JsonProperty("reputation_crimes_uk")
    private String reputationCrimesUk;
    
    @JsonProperty("reputation_convictions_en")
    private String reputationConvictionsEn;
    
    @JsonProperty("reputation_crimes_en")
    private String reputationCrimesEn;
    
    @JsonProperty("reputation_manhunt_en")
    private String reputationManhuntEn;
    
    @JsonProperty("reputation_sanctions_en")
    private String reputationSanctionsEn;
    
    @JsonProperty("reputation_assets_en")
    private String reputationAssetsEn;
    
    @JsonProperty("reputation_assets_uk")
    private String reputationAssetsUk;
    
    @JsonProperty("url")
    private String url;
    
    @JsonProperty("wiki_uk")
    private String wikiUk;
    
    @JsonProperty("wiki_en")
    private String wikiEn;
    
    @JsonProperty("names")
    private String names;
    
    @JsonProperty("related_persons")
    private List<RelatedPersonData> relatedPersonData;
    
    @JsonProperty("related_companies")
    private List<RelatedCompanyData> relatedCompanies;
    
    @JsonProperty("declarations")
    private List<DeclarationsData> declarations;
    
    @JsonProperty("related_countries")
    private List<RelatedCountriesData> relatedCountryData;
    
    @Override
    public String toString() {
        return "FamousPeople{" +
                "_id='" + _id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", alsoKnownAsUk='" + alsoKnownAsUk + '\'' +
                ", patronymicEn='" + patronymicEn + '\'' +
                ", fullNameEn='" + fullNameEn + '\'' +
                ", firstNameEn='" + firstNameEn + '\'' +
                ", lastNameEn='" + lastNameEn + '\'' +
                ", alsoKnownAsEn='" + alsoKnownAsEn + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", isPep=" + isPep +
                ", died=" + died +
                ", photo='" + photo + '\'' +
                ", cityOfBirthUk='" + cityOfBirthUk + '\'' +
                ", cityOfBirthEn='" + cityOfBirthEn + '\'' +
                ", typeOfOfficial='" + typeOfOfficial + '\'' +
                ", typeOfOfficialEn='" + typeOfOfficialEn + '\'' +
                ", lastJobTitle='" + lastJobTitle + '\'' +
                ", lastWorkplace='" + lastWorkplace + '\'' +
                ", lastWorkplaceEn='" + lastWorkplaceEn + '\'' +
                ", lastJobTitleEn='" + lastJobTitleEn + '\'' +
                ", reasonOfTermination='" + reasonOfTermination + '\'' +
                ", reasonOfTerminationEn='" + reasonOfTerminationEn + '\'' +
                ", terminationDateHuman='" + terminationDateHuman + '\'' +
                ", reputationConvictionsUk='" + reputationConvictionsUk + '\'' +
                ", reputationManhuntUk='" + reputationManhuntUk + '\'' +
                ", reputationSanctionsUk='" + reputationSanctionsUk + '\'' +
                ", reputationCrimesUk='" + reputationCrimesUk + '\'' +
                ", reputationConvictionsEn='" + reputationConvictionsEn + '\'' +
                ", reputationCrimesEn='" + reputationCrimesEn + '\'' +
                ", reputationManhuntEn='" + reputationManhuntEn + '\'' +
                ", reputationSanctionsEn='" + reputationSanctionsEn + '\'' +
                ", reputationAssetsEn='" + reputationAssetsEn + '\'' +
                ", reputationAssetsUk='" + reputationAssetsUk + '\'' +
                ", url='" + url + '\'' +
                ", wikiUk='" + wikiUk + '\'' +
                ", wikiEn='" + wikiEn + '\'' +
                ", names='" + names + '\'' +
                ", relatedPersons=" + relatedPersonData +
                ", relatedCompanies=" + relatedCompanies +
                ", declarations=" + declarations +
                ", relatedCountries=" + relatedCountryData +
                '}';
    }
}
