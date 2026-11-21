package com.bibliotecaigor.biblioteca_igor;

public class Professor extends Leitor {
    private String departamento;

    public Professor(String nome, String cpf, String codigoLeitor, String departamento) {
        super(nome, cpf, codigoLeitor);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public int getLimiteDiasEmprestimo() {
        return 30;
    }

    @Override
    public int getLimiteItensEmprestimo() {
        return 10;
    }

    @Override
    public String getIdentificacao() {
        return "Professor: " + getNome() + " (Depto: " + departamento + ")";
    }
}