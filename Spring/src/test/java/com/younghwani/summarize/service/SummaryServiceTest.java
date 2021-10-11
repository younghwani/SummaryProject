package com.younghwani.summarize.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SummaryServiceTest {

    @Test
    void callSummaryAPI() throws Exception {
        String baseUrl = "http://127.0.0.1:5000/test";

        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(baseUrl, String.class);

        System.out.println(response);
    }
}