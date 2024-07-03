package com.sirkaue.LiterAlura.domain.model;

import com.sirkaue.LiterAlura.domain.dto.AutorDto;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;
    private Integer data_nascimeto;
    private Integer data_falecimento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Livro> livros = new HashSet<>();

    public Autor() {
    }

    public Autor(AutorDto dadosAutor) {
        this.nome = dadosAutor.autor();
        this.data_nascimeto = dadosAutor.data_nascimento();
        this.data_falecimento = dadosAutor.data_falecimento();
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

    public Integer getData_nascimeto() {
        return data_nascimeto;
    }

    public void setData_nascimeto(Integer data_nascimeto) {
        this.data_nascimeto = data_nascimeto;
    }

    public Integer getData_falecimento() {
        return data_falecimento;
    }

    public void setData_falecimento(Integer data_falecimento) {
        this.data_falecimento = data_falecimento;
    }

    public Set<Livro> getLivros() {
        return livros;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Ano de nascimento: ").append(data_nascimeto).append("\n");
        sb.append("Ano de falecimento: ").append(data_falecimento).append("\n");
        sb.append("Livros: ").append(livros).append("\n");
        return sb.toString();
    }
}
