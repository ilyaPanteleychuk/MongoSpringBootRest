package com.ilyapanteleychuk.mongorest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import java.util.Objects;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document("test2")
public class FamousPeople {
    
    @Id
    @JsonIgnore()
    private String _id;
    private String first_name;
    private String last_name;
    private String full_name;
    private String patronymic;
    private String also_known_as_uk;
    private String patronymic_en;
    private String full_name_en;
    private String first_name_en;
    private String last_name_en;
    private String also_known_as_en;
    private String date_of_birth;
    @JsonProperty("is_pep")
    private boolean isPep;
    private boolean died;
    private String photo;
    private String city_of_birth_uk;
    private String city_of_birth_en;
    private String type_of_official;
    private String type_of_official_en;
    private String last_job_title;
    private String last_workplace;
    private String last_workplace_en;
    private String last_job_title_en;
    private String reason_of_termination;
    private String reason_of_termination_en;
    private String termination_date_human;
    private String reputation_convictions_uk;
    private String reputation_manhunt_uk;
    private String reputation_sanctions_uk;
    private String reputation_crimes_uk;
    private String reputation_convictions_en;
    private String reputation_crimes_en;
    private String reputation_manhunt_en;
    private String reputation_sanctions_en;
    private String reputation_assets_en;
    private String reputation_assets_uk;
    private String url;
    private String wiki_uk;
    private String wiki_en;
    private String names;
    private List<RelatedPerson> related_persons;
    private List<RelatedCompany> related_companies;
    private List<Declarations> declarations;
    private List<RelatedCountries> related_countries;
    
    @Override
    public String toString() {
        return "FamousPeople{" +
                "photo='" + photo + '\'' +
                ", _id='" + _id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", full_name='" + full_name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", also_known_as_uk='" + also_known_as_uk + '\'' +
                ", patronymic_en='" + patronymic_en + '\'' +
                ", full_name_en='" + full_name_en + '\'' +
                ", first_name_en='" + first_name_en + '\'' +
                ", last_name_en='" + last_name_en + '\'' +
                ", also_known_as_en='" + also_known_as_en + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", is_pep=" + isPep +
                ", died=" + died +
                ", city_of_birth_uk='" + city_of_birth_uk + '\'' +
                ", city_of_birth_en='" + city_of_birth_en + '\'' +
                ", type_of_official='" + type_of_official + '\'' +
                ", type_of_official_en='" + type_of_official_en + '\'' +
                ", last_job_title='" + last_job_title + '\'' +
                ", last_workplace='" + last_workplace + '\'' +
                ", last_workplace_en='" + last_workplace_en + '\'' +
                ", last_job_title_en='" + last_job_title_en + '\'' +
                ", reason_of_termination='" + reason_of_termination + '\'' +
                ", reason_of_termination_en='" + reason_of_termination_en + '\'' +
                ", termination_date_human='" + termination_date_human + '\'' +
                ", reputation_convictions_uk='" + reputation_convictions_uk + '\'' +
                ", reputation_manhunt_uk='" + reputation_manhunt_uk + '\'' +
                ", reputation_sanctions_uk='" + reputation_sanctions_uk + '\'' +
                ", reputation_crimes_uk='" + reputation_crimes_uk + '\'' +
                ", reputation_convictions_en='" + reputation_convictions_en + '\'' +
                ", reputation_crimes_en='" + reputation_crimes_en + '\'' +
                ", reputation_manhunt_en='" + reputation_manhunt_en + '\'' +
                ", reputation_sanctions_en='" + reputation_sanctions_en + '\'' +
                ", reputation_assets_en='" + reputation_assets_en + '\'' +
                ", url='" + url + '\'' +
                ", wiki_uk='" + wiki_uk + '\'' +
                ", wiki_en='" + wiki_en + '\'' +
                ", names='" + names + '\'' +
                ", relatedPeople=" + related_persons +
                ", relatedCompanies=" + related_companies +
                ", declarations=" + declarations +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamousPeople that = (FamousPeople) o;
        return isPep == that.isPep && died == that.died && Objects.equals(_id, that._id) && Objects.equals(first_name, that.first_name) && Objects.equals(last_name, that.last_name) && Objects.equals(full_name, that.full_name) && Objects.equals(patronymic, that.patronymic) && Objects.equals(also_known_as_uk, that.also_known_as_uk) && Objects.equals(patronymic_en, that.patronymic_en) && Objects.equals(full_name_en, that.full_name_en) && Objects.equals(first_name_en, that.first_name_en) && Objects.equals(last_name_en, that.last_name_en) && Objects.equals(also_known_as_en, that.also_known_as_en) && Objects.equals(date_of_birth, that.date_of_birth) && Objects.equals(photo, that.photo) && Objects.equals(city_of_birth_uk, that.city_of_birth_uk) && Objects.equals(city_of_birth_en, that.city_of_birth_en) && Objects.equals(type_of_official, that.type_of_official) && Objects.equals(type_of_official_en, that.type_of_official_en) && Objects.equals(last_job_title, that.last_job_title) && Objects.equals(last_workplace, that.last_workplace) && Objects.equals(last_workplace_en, that.last_workplace_en) && Objects.equals(last_job_title_en, that.last_job_title_en) && Objects.equals(reason_of_termination, that.reason_of_termination) && Objects.equals(reason_of_termination_en, that.reason_of_termination_en) && Objects.equals(termination_date_human, that.termination_date_human) && Objects.equals(reputation_convictions_uk, that.reputation_convictions_uk) && Objects.equals(reputation_manhunt_uk, that.reputation_manhunt_uk) && Objects.equals(reputation_sanctions_uk, that.reputation_sanctions_uk) && Objects.equals(reputation_crimes_uk, that.reputation_crimes_uk) && Objects.equals(reputation_convictions_en, that.reputation_convictions_en) && Objects.equals(reputation_crimes_en, that.reputation_crimes_en) && Objects.equals(reputation_manhunt_en, that.reputation_manhunt_en) && Objects.equals(reputation_sanctions_en, that.reputation_sanctions_en) && Objects.equals(reputation_assets_en, that.reputation_assets_en) && Objects.equals(reputation_assets_uk, that.reputation_assets_uk) && Objects.equals(url, that.url) && Objects.equals(wiki_uk, that.wiki_uk) && Objects.equals(wiki_en, that.wiki_en) && Objects.equals(names, that.names) && Objects.equals(related_persons, that.related_persons) && Objects.equals(related_companies, that.related_companies) && Objects.equals(declarations, that.declarations) && Objects.equals(related_countries, that.related_countries);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(_id, first_name, last_name, full_name, patronymic,
                also_known_as_uk, patronymic_en, full_name_en, first_name_en,
                last_name_en, also_known_as_en, date_of_birth, isPep, died, photo,
                city_of_birth_uk, city_of_birth_en, type_of_official, type_of_official_en,
                last_job_title, last_workplace, last_workplace_en, last_job_title_en,
                reason_of_termination, reason_of_termination_en, termination_date_human,
                reputation_convictions_uk, reputation_manhunt_uk, reputation_sanctions_uk,
                reputation_crimes_uk, reputation_convictions_en, reputation_crimes_en,
                reputation_manhunt_en, reputation_sanctions_en, reputation_assets_en,
                reputation_assets_uk, url, wiki_uk, wiki_en, names, related_persons,
                related_companies, declarations, related_countries);
    }
}
