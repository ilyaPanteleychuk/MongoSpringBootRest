package com.ilyapanteleychuk.mongorest.service;

import com.ilyapanteleychuk.mongorest.dto.FamousPeopleInfoDto;
import com.ilyapanteleychuk.mongorest.dto.FamousPeopleSearchDto;
import com.ilyapanteleychuk.mongorest.dto.MostPopularPeopleDto;
import com.ilyapanteleychuk.mongorest.dto.PageDto;
import com.ilyapanteleychuk.mongorest.model.FamousPeople;
import com.ilyapanteleychuk.mongorest.repository.FamousPeopleCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;


@Service
@RequiredArgsConstructor
public class FamousPeopleService {
    
    private final FileProcessorService fileProcessorService;
    private final FamousPeopleCustomRepository famousPeopleRepository;
    
    //this logic should be replaced
    public void fillDbFromFile(MultipartFile multipartFile){
        famousPeopleRepository
                .saveAll(fileProcessorService.parseJsonContent(multipartFile));
    }
    
    public PageDto<FamousPeopleInfoDto> searchPeople(FamousPeopleSearchDto searchDto) {
        Page<FamousPeople> page = famousPeopleRepository.search(searchDto);
        return PageDto.fromPage(page, this::toInfoDto);
    }
    
    public List<MostPopularPeopleDto> showStatistic() {
        return famousPeopleRepository.calculateStatistic();
    }
    
    private FamousPeopleInfoDto toInfoDto(FamousPeople famousPeople){
        return FamousPeopleInfoDto.builder()
                .fullName(famousPeople.getFull_name())
                .isPep(famousPeople.isPep())
                .died(famousPeople.isDied())
                .build();
    }
}
