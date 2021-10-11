package com.younghwani.summarize.converter;


import com.younghwani.summarize.dto.SummaryDto;
import com.younghwani.summarize.entity.Summary;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SummaryConverter {

    ModelMapper modelMapper = new ModelMapper();

    public Summary dtoToEntity(SummaryDto summaryDto) {
        Summary summary = modelMapper.map(summaryDto, Summary.class);
        return summary;
    }

    public SummaryDto entityToDto(Summary summary) {
        SummaryDto summaryDto = modelMapper.map(summary, SummaryDto.class);
        return summaryDto;
    }
}
