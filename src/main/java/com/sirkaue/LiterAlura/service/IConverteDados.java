package com.sirkaue.LiterAlura.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
