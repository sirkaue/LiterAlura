package com.sirkaue.LiterAlura.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultsDto(@JsonAlias("results") List<LivroDto> resultados) {
}
