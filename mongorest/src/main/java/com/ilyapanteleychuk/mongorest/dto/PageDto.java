package com.ilyapanteleychuk.mongorest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.function.Function;


@Getter
@Builder
@Jacksonized
public class PageDto<T> {

    private List<T> list;
    
    private long totalPages;
    
    private long totalSize;
    
    public static <T, D>PageDto<D> fromPage(Page<T> page, Function<T, D> function){
        List<D> convertedList = page.stream().map(function).toList();
        return PageDto.<D>builder()
                .list(convertedList)
                .totalPages(page.getTotalPages())
                .totalSize(page.getTotalElements())
                .build();
    }
}
