package com.sirkaue.LiterAlura.domain.model;

import com.sirkaue.LiterAlura.domain.dto.LivroDto;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String linguagem;
    private Integer numero_downloads;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Livro() {
    }

    public Livro(LivroDto livroDto, Autor autor) {
        this.titulo = livroDto.titulo();
        this.linguagem = livroDto.idiomas().toString();
        this.numero_downloads = livroDto.numero_downloads();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public Integer getNumero_downloads() {
        return numero_downloads;
    }

    public void setNumero_downloads(Integer numero_downloads) {
        this.numero_downloads = numero_downloads;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return this.titulo;
    }
}
