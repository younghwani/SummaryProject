package com.younghwani.summarize.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.younghwani.summarize.converter.SummaryConverter;
import com.younghwani.summarize.dto.SummaryDto;
import com.younghwani.summarize.entity.Summary;
import com.younghwani.summarize.repository.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SummaryService {

    @Autowired
    SummaryRepository summaryRepository;
    @Autowired
    SummaryConverter summaryConverter;

    public List<Summary> findAllSummary() {
        return summaryRepository.findAll();
    }
    public Optional<Summary> findOneSummary(Long id) {
        return summaryRepository.findById(id);
    }

    @Transactional
    public void putSummaryEntity(Summary summary) {
        summaryRepository.save(summary);
    }

    @Transactional
    public void putSummaryDto(SummaryDto summaryDto) {
        Summary summary = summaryConverter.dtoToEntity(summaryDto);
        summaryRepository.save(summary);
    }

    @Transactional
    public String callSummaryAPI(String input) {

        String baseUrl = "http://127.0.0.1:5000/summarize?text=" + input;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(baseUrl, String.class);

        return response;
    }

    @Transactional
    public String callKobartSummaryAPI(String input) {

        String baseUrl = "http://127.0.0.1:5000/kobartSum?text=" + input;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(baseUrl, String.class);

        return response;
    }
}
