/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibliotecaigor.biblioteca_igor;

/**
 *
 * @author leonardo
 */

//criei varios generos de livros mas so usei um kkkkkk
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