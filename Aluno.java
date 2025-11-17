/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibliotecaigor.biblioteca_igor;

/**
 *
 * @author leonardo
 */
public class Aluno extends Leitor {
    private String matricula;

    public Aluno(String nome, String cpf, String codigoLeitor, String matricula) {
        super(nome, cpf, codigoLeitor);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }


    @Override
    public int getLimiteDiasEmprestimo() {
        return 15;
    }

    @Override
    public String getIdentificacao() {
        return "Aluno: " + getNome() + " (Matrícula: " + matricula + ")";
    }
}