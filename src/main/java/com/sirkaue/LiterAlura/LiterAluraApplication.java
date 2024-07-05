package com.sirkaue.LiterAlura;

import com.sirkaue.LiterAlura.menu.Menu;
import com.sirkaue.LiterAlura.repository.AutorRepository;
import com.sirkaue.LiterAlura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private AutorRepository autorRepository;

    public static void main(String[] args) {
        SpringApplication.run(LiterAluraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Menu menu = new Menu(autorRepository, repository);
        menu.exibeMenu();
    }
}
