package com.sirkaue.LiterAlura.model;

import com.sirkaue.LiterAlura.dto.AutorDto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer anoNascimento;
    private Integer anoFalecimento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livros = new ArrayList<>();

    public Autor() {
    }

    public Autor(AutorDto autorDto) {
        this.nome = autorDto.getNome();
        this.anoNascimento = autorDto.getAnoNascimento();
        this.anoFalecimento = autorDto.getAnoFalecimento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        livros.forEach(l -> l.setAutor(this));
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "---------------Autor---------------" +
                "\nnome: " + nome +
                "\nData de Nascimento: " + getAnoNascimento() +
                "\nData de Falecimento: " + getAnoFalecimento() +
                "\nLivro: " + livros.stream()
                .map(livros -> livros.getTitulo())
                .collect(Collectors.toList()) +
                "\n-----------------------------------";

    }
}
