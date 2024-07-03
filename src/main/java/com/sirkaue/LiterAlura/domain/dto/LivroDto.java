package com.sirkaue.LiterAlura.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDto(@JsonAlias("title") String titulo,
                       @JsonAlias("authors") List<AutorDto> autores,
                       @JsonAlias("languages") List<String> idiomas,
                       @JsonAlias("download_count") Integer numero_downloads) {
}
