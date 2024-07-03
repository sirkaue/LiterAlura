package com.sirkaue.LiterAlura.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDto(@JsonAlias("name") String autor,
                       @JsonAlias("birth_year") Integer data_nascimento,
                       @JsonAlias("death_year") Integer data_falecimento) {

}
