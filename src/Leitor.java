package com.bibliotecaigor.biblioteca_igor;

import java.util.ArrayList;
import java.util.List;

public abstract class Leitor extends Pessoa {
    private String codigoLeitor;
    private List<Emprestimo> emprestimosAtivos;

    public Leitor(String nome, String cpf, String codigoLeitor) {
        super(nome, cpf);
        this.codigoLeitor = codigoLeitor;
        this.emprestimosAtivos = new ArrayList<>();
    }

    public String getCodigoLeitor() {
        return codigoLeitor;
    }

    public List<Emprestimo> getEmprestimosAtivos() {
        return emprestimosAtivos;
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        this.emprestimosAtivos.add(emprestimo);
    }

    public void removerEmprestimo(Emprestimo emprestimo) {
        this.emprestimosAtivos.remove(emprestimo);
    }

    public int getQuantidadeEmprestimosAtivos() {
        return this.emprestimosAtivos.size();
    }

    @Override
    public String getIdentificacao() {
        return "Leitor: " + getNome() + " (Cód: " + codigoLeitor + ")";
    }

    public abstract int getLimiteDiasEmprestimo();

    public int getLimiteItensEmprestimo() {
        return 3; // coloquei o limite padrao como 3 mas as subclasses podem
        //alterar isso via override
    }
}
