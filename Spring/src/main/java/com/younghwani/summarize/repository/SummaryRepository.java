package com.younghwani.summarize.repository;

import com.younghwani.summarize.entity.Summary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummaryRepository extends JpaRepository<Summary, Long> {
}
