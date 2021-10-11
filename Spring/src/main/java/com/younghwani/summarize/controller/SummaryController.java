package com.younghwani.summarize.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.younghwani.summarize.entity.Summary;
import com.younghwani.summarize.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SummaryController {

    @Autowired
    SummaryService summaryService;

    @PostMapping("/list")
    public List<Summary> summaryList() {
        List<Summary> summaries = summaryService.findAllSummary();
        return summaries;
    }

    @GetMapping("/result/{id}")
    ResponseEntity<?> getSummary(@PathVariable Long id) {
        Optional<Summary> summary = summaryService.findOneSummary(id);
        return summary.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/summary")
    public Summary summarize(
        @RequestParam(value = "text") String input) throws Exception {

        // Flask Summarize Server와 연동
        String output = summaryService.callSummaryAPI(input);

        Summary summary = new Summary(input, output);
        summaryService.putSummaryEntity(summary);

        return summary;
    }

}
