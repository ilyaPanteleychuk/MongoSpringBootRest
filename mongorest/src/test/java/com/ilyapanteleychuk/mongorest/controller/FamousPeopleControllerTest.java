package com.ilyapanteleychuk.mongorest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ilyapanteleychuk.mongorest.MongorestApplication;
import com.ilyapanteleychuk.mongorest.dto.FamousPeopleInfoDto;
import com.ilyapanteleychuk.mongorest.dto.FamousPeopleSearchDto;
import com.ilyapanteleychuk.mongorest.dto.PopularPeopleDto;
import com.ilyapanteleychuk.mongorest.dto.PageDto;
import com.ilyapanteleychuk.mongorest.model.FamousPeopleData;
import com.ilyapanteleychuk.mongorest.repository.FamousPeopleCustomRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = MongorestApplication.class)
@AutoConfigureMockMvc
class FamousPeopleControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().registerModule(new JavaTimeModule());
    
    @Autowired
    private FamousPeopleCustomRepository famousPeopleRepository;
    
    @AfterEach
    void afterEach(){
        famousPeopleRepository.deleteAll();
    }
    
    @Test
    void search_shouldReturnPeopleByName_whenOnlyNameSpecified() throws Exception {
        FamousPeopleData person1 = buildFamousPeople
                ("Ilya", "Panteleychuk", "Michailovich", true);
        FamousPeopleData person2 = buildFamousPeople
                ("Anastasia", "Butevich", "Igorivna", true);
        FamousPeopleData person3 = buildFamousPeople
                ("Volodimir", "Lelavin", "Volodimirovich", false);
        List<FamousPeopleData> famousPeopleData = List.of(person1, person2, person3);
        famousPeopleRepository.saveAll(famousPeopleData);
        FamousPeopleSearchDto searchDto = FamousPeopleSearchDto.builder()
                .firstName("Ilya")
                .build();
        MockHttpServletResponse response =
                mockMvc.perform(post("/api/v1/people/_search")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(OBJECT_MAPPER.writeValueAsString(searchDto)))
                .andExpect(status().isOk()).andReturn().getResponse();
        PageDto<FamousPeopleInfoDto> result = parseJson(response.getContentAsString(),
                new TypeReference<>() {});
        assertThat(result.getTotalPages()).isEqualTo(1);
        assertThat(result.getTotalSize()).isEqualTo(1);
        assertThat(result.getList().size()).isEqualTo(1);
        assertThat(result.getList().get(0).getFullName())
                .isEqualTo("Panteleychuk Ilya Michailovich");
        assertThat(result.getList().get(0).isPep()).isEqualTo(true);
        assertThat(result.getList().get(0).isDied()).isEqualTo(false);
    }
    
    @Test
    void search_shouldReturnPeopleByNameAndPatronymic_whenPatronymicAndNameSpecified() throws Exception {
        FamousPeopleData person1 = buildFamousPeople
                ("Ilya", "Panteleychuk", "Michailovich", true);
        FamousPeopleData person2 = buildFamousPeople
                ("Anastasia", "Butevich", "Igorivna", true);
        FamousPeopleData person3 = buildFamousPeople
                ("Volodimir", "Lelavin", "Volodimirovich", false);
        FamousPeopleData person4 = buildFamousPeople
                ("Ilya", "Ivanov", "Ivanovich", false);
        FamousPeopleData person5 = buildFamousPeople
                ("Ilya", "Sidorov", "Michailovich", true);
        List<FamousPeopleData> famousPeopleData = List.of(person1, person2, person3, person4, person5);
        famousPeopleRepository.saveAll(famousPeopleData);
        FamousPeopleSearchDto searchDto = FamousPeopleSearchDto.builder()
                .firstName("Ilya")
                .patronymic("Michailovich")
                .build();
        MockHttpServletResponse response =
                mockMvc.perform(post("/api/v1/people/_search")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(OBJECT_MAPPER.writeValueAsString(searchDto)))
                        .andExpect(status().isOk()).andReturn().getResponse();
        PageDto<FamousPeopleInfoDto> result = parseJson(response.getContentAsString(),
                new TypeReference<>() {});
        assertThat(result.getTotalPages()).isEqualTo(1);
        assertThat(result.getTotalSize()).isEqualTo(2);
        assertThat(result.getList().size()).isEqualTo(2);
        assertThat(result.getList().get(0).getFullName())
                .isEqualTo("Panteleychuk Ilya Michailovich");
        assertThat(result.getList().get(0).isPep()).isEqualTo(true);
        assertThat(result.getList().get(0).isDied()).isEqualTo(false);
        assertThat(result.getList().get(1).getFullName())
                .isEqualTo("Sidorov Ilya Michailovich");
        assertThat(result.getList().get(0).isPep()).isEqualTo(true);
        assertThat(result.getList().get(0).isDied()).isEqualTo(false);
    }
    
    @Test
    void showStatistic_shouldReturnOnlyPepPeopleWithAmount_whenSuchExists() throws Exception {
        FamousPeopleData person1 = buildFamousPeople
                ("Ilya", "Panteleychuk", "Michailovich", true);
        FamousPeopleData person2 = buildFamousPeople
                ("Anastasia", "Butevich", "Igorivna", true);
        FamousPeopleData person3 = buildFamousPeople
                ("Volodimir", "Lelavin", "Volodimirovich", false);
        FamousPeopleData person4 = buildFamousPeople
                ("Ilya", "Ivanov", "Ivanovich", false);
        FamousPeopleData person5 = buildFamousPeople
                ("Ilya", "Sidorov", "Michailovich", true);
        List<FamousPeopleData> famousPeopleData = List.of(person1, person2, person3, person4, person5);
        famousPeopleRepository.saveAll(famousPeopleData);
        MockHttpServletResponse response =
                mockMvc.perform(get("/api/v1/people/showStatistic")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse();
        List<PopularPeopleDto> result = parseJson(response.getContentAsString(), new TypeReference<>() {});
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getFirstName()).isEqualTo("Ilya");
        assertThat(result.get(0).getAmount()).isEqualTo(2);
        assertThat(result.get(1).getFirstName()).isEqualTo("Anastasia");
        assertThat(result.get(1).getAmount()).isEqualTo(1);
    }
    
    
    public static <T>T parseJson(String json, TypeReference<T> valueTypeRef) {
        try {
            return OBJECT_MAPPER.readValue(json, valueTypeRef);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing json", e);
        }
    }
    
    private static FamousPeopleData buildFamousPeople(String firstName,
                                                      String lastName,
                                                      String patronymic,
                                                      boolean isPep)
    {
        String fullName = lastName.concat(" ").concat(firstName).concat( " ")
                .concat(patronymic);
        FamousPeopleData famousPeople = new FamousPeopleData();
        famousPeople.setPatronymic(patronymic);
        famousPeople.setFirstName(firstName);
        famousPeople.setLastName(lastName);
        famousPeople.setFullName(fullName);
        famousPeople.setPep(isPep);
        famousPeople.setDied(false);
        return famousPeople;
    }
}