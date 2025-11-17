/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibliotecaigor.biblioteca_igor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author leonardo
 */

public class Emprestimo {
    private Leitor leitor;
    private ItemAcervo item;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    private StatusEmprestimo status;

    public Emprestimo(Leitor leitor, ItemAcervo item, int diasParaDevolucao) {
        this.leitor = leitor;
        this.item = item;
        this.dataEmprestimo = LocalDate.now();
        // polimorfismo aqui foi usado para calcular o limite
        this.dataDevolucaoPrevista = this.dataEmprestimo.plusDays(diasParaDevolucao);
        this.status = StatusEmprestimo.ATIVO;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public ItemAcervo getItem() {
        return item;
    }

    public StatusEmprestimo getStatus() {
        return status;
    }

    public void finalizar() {
        this.dataDevolucaoReal = LocalDate.now();
        this.status = StatusEmprestimo.CONCLUIDO;

        if (this.dataDevolucaoReal.isAfter(this.dataDevolucaoPrevista)) {
            this.status = StatusEmprestimo.ATRASADO;
        }
    }

    public double calcularMulta() {
        if (status == StatusEmprestimo.ATRASADO) {
            long diasAtraso = ChronoUnit.DAYS.between(dataDevolucaoPrevista, dataDevolucaoReal);
            return diasAtraso * 1.50; // um e cinquenta por dia de atraso
        }
        return 0.0;
    }

    @Override
    public String toString() {
        String devReal = (dataDevolucaoReal != null) ? dataDevolucaoReal.toString() : "N/A";
        return "Emprestimo [" +
                "Leitor: " + leitor.getNome() +
                ", Item: " + item.getTitulo() +
                ", Data: " + dataEmprestimo +
                ", Prev. Devolução: " + dataDevolucaoPrevista +
                ", Devolução Real: " + devReal +
                ", Status: " + status +
                ']';
    }
}