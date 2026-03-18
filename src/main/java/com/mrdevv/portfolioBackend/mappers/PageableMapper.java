package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.PageableData;
import org.springframework.data.domain.Page;

public class PageableMapper {

    public static PageableData toPageable(Page page){
        return new PageableData(
                page.getPageable().getPageNumber(),
                page.isLast(),
                page.isFirst(),
                page.getTotalPages(),
                page.getTotalElements(),
                page.getNumberOfElements(),
                page.getPageable().getOffset()
        );

    }

}
