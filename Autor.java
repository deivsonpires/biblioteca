/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibliotecaigor.biblioteca_igor;

/**
 *
 * @author leonardo
 */
public class Autor extends Pessoa {
    private String biografia;

    public Autor(String nome, String cpf, String biografia) {
        super(nome, cpf); 
        this.biografia = biografia;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    @Override
    public String getIdentificacao() {
        return "Autor: " + getNome();
    }

    @Override
    public String toString() {
        return getNome(); 
    }
}