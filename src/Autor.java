package com.bibliotecaigor.biblioteca_igor;

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