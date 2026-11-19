package com.bibliotecaigor.biblioteca_igor;

public abstract class Pessoa {

    private String nome;
    private String cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        // uma validaçao de cpf bem simples
        if (cpf != null && cpf.matches("\\d{11}")) {
            this.cpf = cpf;
        } else {
            System.err.println("CPF inválido para: " + this.nome);
        }
    }

    public abstract String getIdentificacao();
}
