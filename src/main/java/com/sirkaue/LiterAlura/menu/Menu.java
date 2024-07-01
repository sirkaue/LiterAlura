package com.sirkaue.LiterAlura.menu;

import com.sirkaue.LiterAlura.service.ConsumoApi;
import com.sirkaue.LiterAlura.service.ConverteDados;

import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books/?search=";

    public void exibeMenu() {

    }
}
