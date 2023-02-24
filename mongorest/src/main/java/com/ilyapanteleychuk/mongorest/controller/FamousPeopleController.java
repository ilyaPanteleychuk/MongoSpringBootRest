package com.ilyapanteleychuk.mongorest.controller;

import com.ilyapanteleychuk.mongorest.dto.FamousPeopleSearchDto;
import com.ilyapanteleychuk.mongorest.dto.FamousPeopleInfoDto;
import com.ilyapanteleychuk.mongorest.dto.PopularPeopleDto;
import com.ilyapanteleychuk.mongorest.dto.PageDto;
import com.ilyapanteleychuk.mongorest.model.FamousPeopleData;
import com.ilyapanteleychuk.mongorest.service.FamousPeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;


/**
 * Controller for managing endpoints related with
 * {@link FamousPeopleData} entity class
 *
 * @author Ilya Panteleychuk
 */
@RestController
@RequestMapping("api/v1/people")
@RequiredArgsConstructor
public class FamousPeopleController {

    private final FamousPeopleService famousPeopleService;
    
    @PostMapping("_search")
    @ResponseStatus(HttpStatus.OK)
    public PageDto<FamousPeopleInfoDto> search(@RequestBody FamousPeopleSearchDto searchDto){
        return famousPeopleService.searchPeople(searchDto);
    }
    
    @GetMapping("showStatistic")
    @ResponseStatus(HttpStatus.OK)
    public List<PopularPeopleDto> showStatistic(){
        return famousPeopleService.showStatistic();
    }
}
