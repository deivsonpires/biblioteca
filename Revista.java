/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibliotecaigor.biblioteca_igor;

/**
 *
 * @author leonardo
 */
public class Revista extends ItemAcervo {
    private String issn;
    private int volume;

    public Revista(String codigo, String titulo, int anoPublicacao, String issn, int volume) {
        super(codigo, titulo, anoPublicacao);
        this.issn = issn;
        this.volume = volume;
    }

    public String getIssn() {
        return issn;
    }

    public int getVolume() {
        return volume;
    }

    /**
     * aqui ele pede uma return tag sendo que já tem uma com false, não faço a 
     * minima ideia o por que, e tenho raiva de quem sabe
     */
    @Override
    public boolean emprestarItem() {
        System.out.println("revistas não podem ser emprestadas. apenas consulta local.");
        return false;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("--- Revista ---");
        System.out.println("Título: " + getTitulo() + " (Cód: " + getCodigo() + ")");
        System.out.println("Volume: " + this.volume);
        System.out.println("Ano: " + getAnoPublicacao());
        System.out.println("ISSN: " + getIssn());
        System.out.println("Disponível: " + (isDisponivel() ? "Sim (Consulta Local)" : "N/A"));
    }
}