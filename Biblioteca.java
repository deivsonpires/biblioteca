/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibliotecaigor.biblioteca_igor;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class Biblioteca {
    
    private List<ItemAcervo> acervo;
    private List<Leitor> leitores;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.acervo = new ArrayList<>();
        this.leitores = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void cadastrarItem(ItemAcervo item) {
        this.acervo.add(item);
        System.out.println("Item cadastrado: " + item.getTitulo());
    }

    public void cadastrarLeitor(Leitor leitor) {
        this.leitores.add(leitor);
        System.out.println("Leitor cadastrado: " + leitor.getNome());
    }

    public void listarAcervo() {
        System.out.println("\n--- LISTA DE ITENS NO ACERVO ---");
        if (acervo.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
            return;
        }
        for (ItemAcervo item : acervo) {
         
            item.exibirDetalhes();
            System.out.println("--------------------------");
        }
    }

    public void listarLeitores() {
        System.out.println("\n--- LISTA DE LEITORES ---");
        if (leitores.isEmpty()) {
            System.out.println("Nenhum leitor cadastrado.");
            return;
        }
        for (Leitor leitor : leitores) {
          
            System.out.println(leitor.getIdentificacao());
        }
    }

    public void listarEmprestimosAtivos() {
        System.out.println("\n--- EMPRÉSTIMOS ATIVOS ---");
        boolean encontrou = false;
        for (Emprestimo e : emprestimos) {
            if (e.getStatus() == StatusEmprestimo.ATIVO) {
                System.out.println(e);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum empréstimo ativo no momento.");
        }
    }

    public void realizarEmprestimo(String codigoLeitor, String codigoItem) {
        System.out.println("\n--- TENTATIVA DE EMPRÉSTIMO ---");
        Leitor leitor = buscarLeitor(codigoLeitor);
        ItemAcervo item = buscarItem(codigoItem);

        if (leitor == null || item == null) {
            System.err.println("Erro: Leitor ou Item não encontrado.");
            return;
        }

        if (leitor.getQuantidadeEmprestimosAtivos() >= leitor.getLimiteItensEmprestimo()) {
            System.err.println("Falha: Leitor " + leitor.getNome() + " atingiu o limite de " + leitor.getLimiteItensEmprestimo() + " empréstimos.");
            return;
        }

  
        if (!item.emprestarItem()) {
            System.err.println("Falha: Item " + item.getTitulo() + " não está disponível ou não pode ser emprestado.");
            return;
        }

        int diasEmprestimo = leitor.getLimiteDiasEmprestimo();
        Emprestimo emprestimo = new Emprestimo(leitor, item, diasEmprestimo);

      
        this.emprestimos.add(emprestimo);
        leitor.adicionarEmprestimo(emprestimo); 

        System.out.println("Sucesso: " + leitor.getNome() + " emprestou " + item.getTitulo() + ".");
        System.out.println("Devolver em: " + diasEmprestimo + " dias.");
    }

    public void realizarDevolucao(String codigoItem) {
        System.out.println("\n--- TENTATIVA DE DEVOLUÇÃO ---");
        ItemAcervo item = buscarItem(codigoItem);
        if (item == null) {
            System.err.println("Erro: Item não encontrado.");
            return;
        }

        Emprestimo emprestimo = buscarEmprestimoAtivo(codigoItem);
        if (emprestimo == null) {
            System.err.println("Falha: Este item não consta como emprestado.");
            return;
        }

        emprestimo.finalizar();
        item.devolverItem();
        emprestimo.getLeitor().removerEmprestimo(emprestimo);

        System.out.println("Sucesso: Item " + item.getTitulo() + " foi devolvido por " + emprestimo.getLeitor().getNome() + ".");

        // Verifica multas
        if (emprestimo.getStatus() == StatusEmprestimo.ATRASADO) {
            double multa = emprestimo.calcularMulta();
            System.out.printf("ATENÇÃO: Devolução com atraso! Multa gerada: R$ %.2f\n", multa);
        }
    }

    private Leitor buscarLeitor(String codigoLeitor) {
        for (Leitor leitor : leitores) {
            if (leitor.getCodigoLeitor().equals(codigoLeitor)) {
                return leitor;
            }
        }
        return null;
    }

    private ItemAcervo buscarItem(String codigoItem) {
        for (ItemAcervo item : acervo) {
            if (item.getCodigo().equals(codigoItem)) {
                return item;
            }
        }
        return null;
    }

    private Emprestimo buscarEmprestimoAtivo(String codigoItem) {
        for (Emprestimo e : emprestimos) {
            if (e.getItem().getCodigo().equals(codigoItem) && e.getStatus() == StatusEmprestimo.ATIVO) {
                return e;
            }
        }
        return null;
    }
}