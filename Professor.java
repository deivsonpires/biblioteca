/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibliotecaigor.biblioteca_igor;

/**
 *
 * @author leonardo
 */
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