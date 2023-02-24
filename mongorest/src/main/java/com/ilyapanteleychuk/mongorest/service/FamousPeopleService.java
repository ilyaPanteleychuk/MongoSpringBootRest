package com.ilyapanteleychuk.mongorest.service;

import com.ilyapanteleychuk.mongorest.dto.FamousPeopleInfoDto;
import com.ilyapanteleychuk.mongorest.dto.FamousPeopleSearchDto;
import com.ilyapanteleychuk.mongorest.dto.PopularPeopleDto;
import com.ilyapanteleychuk.mongorest.dto.PageDto;
import com.ilyapanteleychuk.mongorest.model.FamousPeopleData;
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
    
    public void fillDbFromFile(MultipartFile multipartFile){
        famousPeopleRepository.saveAll(fileProcessorService.parseJsonContent(multipartFile));
    }
    
    public PageDto<FamousPeopleInfoDto> searchPeople(FamousPeopleSearchDto searchDto) {
        Page<FamousPeopleData> page = famousPeopleRepository.search(searchDto);
        return PageDto.fromPage(page, this::toInfoDto);
    }
    
    public List<PopularPeopleDto> showStatistic() {
        return famousPeopleRepository.calculateStatistic();
    }
    
    private FamousPeopleInfoDto toInfoDto(FamousPeopleData famousPeopleData){
        return FamousPeopleInfoDto.builder()
                .fullName(famousPeopleData.getFullName())
                .isPep(famousPeopleData.isPep())
                .died(famousPeopleData.isDied())
                .build();
    }
}
