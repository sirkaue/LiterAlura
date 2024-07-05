package com.sirkaue.LiterAlura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultDto {

    @JsonAlias("results")
    private List<LivroDto> resultados;

    public List<LivroDto> getResultados() {
        return resultados;
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "resultados=" + resultados +
                '}';
    }
}
