package com.younghwani.summarize.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "summary")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Summary {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "input", nullable = false)
    private String input;

    @Column(name = "output", nullable = true)
    private String output;

    @Builder
    public Summary(String input, String output) {
        this.id = null;
        this.input = input;
        this.output = output;
    }
}

