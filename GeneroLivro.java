package com.bibliotecaigor.biblioteca_igor;

public enum GeneroLivro {
    FICCAO_CIENTIFICA("Ficção Científica"),
    FANTASIA("Fantasia"),
    ROMANCE("Romance"),
    TECNICO("Técnico"),
    HISTORIA("História"),
    BIOGRAFIA("Biografia");

    private String descricao;

    GeneroLivro(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}