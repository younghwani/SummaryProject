package com.younghwani.summarize.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class SummaryDto {
    private Long id;
    private String input;
    private String output;
}
