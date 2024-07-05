package com.sirkaue.LiterAlura.menu;

import com.sirkaue.LiterAlura.dto.LivroDto;
import com.sirkaue.LiterAlura.dto.ResultDto;
import com.sirkaue.LiterAlura.model.Autor;
import com.sirkaue.LiterAlura.model.Livro;
import com.sirkaue.LiterAlura.repository.AutorRepository;
import com.sirkaue.LiterAlura.repository.LivroRepository;
import com.sirkaue.LiterAlura.service.ConsumoApi;
import com.sirkaue.LiterAlura.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books/?search=";
    private LivroRepository livroRepository;
    private AutorRepository autorRepository;
    private List<Autor> autoresList = new ArrayList<>();
    private List<Livro> livroList = new ArrayList<>();

    public Menu(AutorRepository autorRepository, LivroRepository livroRepository) {
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
    }

    public void exibeMenu() {
        int opcao = -1;
        while (opcao != 0) {
            var menu = """
                    ***Opções para escolha***
                    1 - Buscar livros pelo título.
                    2 - Lista de Livros registrados.
                    3 - Lista de autores registrados.
                    4 - Lista de autores registrados vivos em determinado ano.
                    5 - Lista de livros por idioma.

                    0 - Sair.
                    """;

            System.out.println(menu);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivrosPorTitulo();
                    break;
                case 2:
                    listaDeLivrosRegistrados();
                    break;
                case 3:
                    listaDeAutoresRegistrados();
                    break;
                case 4:
                    listaDeAutoresVivosEmDeterminadoAno();
                    break;
                case 5:
                    listaLivrosEmDeterminadoIdioma();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
        sc.close();
    }

    private void buscarLivrosPorTitulo() {
        ResultDto dadosLivros = getDadosLivro();

        if (dadosLivros.getResultados() != null && !dadosLivros.getResultados().isEmpty()) {
            LivroDto livroBuscado = dadosLivros.getResultados().get(0);
            Livro livro = new Livro(livroBuscado);
            System.out.println(livro);
            livroRepository.save(livro);
        } else {
            System.out.println("Nenhum livro encontrado.");
        }
    }

    private void listaDeLivrosRegistrados() {
        livroList = livroRepository.findAll();

        if (livroList.isEmpty()) {
            System.out.println("Nenhum livro registrado.");
        } else {
            livroList.forEach(System.out::println);
        }
    }

    private void listaDeAutoresRegistrados() {
        autoresList = autorRepository.findAll();

        if (autoresList.isEmpty()) {
            System.out.println("Nenhum autor registrado.");
        } else {
            autoresList.forEach(System.out::println);
        }
    }

    private void listaDeAutoresVivosEmDeterminadoAno() {
        System.out.println("Insira o ano que deseja pesquisar:");
        Integer ano = sc.nextInt();
        autoresList = autorRepository.findAllByAno(ano);

        if (autoresList.isEmpty()) {
            System.out.println("Nenhum autor registrado.");
        } else {
            autoresList.forEach(System.out::println);
        }
    }

    private void listaLivrosEmDeterminadoIdioma() {
        System.out.println("""
                Digite o idioma que deseja escolher:
                Pt - Português
                En - Inglês
                Es - Espanhol
                Fr - Francês
                """);

        String idiomaEscolhido = sc.nextLine();
        livroList = livroRepository.findAllByIdioma(idiomaEscolhido);
    }

    private ResultDto getDadosLivro() {
        System.out.println("Digite o nome do livro que deseja buscar: ");
        String nomeLivro = sc.nextLine();
        String json = consumoApi.obterDados(ENDERECO + nomeLivro.replace(" ", "%20"));
        return converteDados.obterDados(json, ResultDto.class);
    }
}
