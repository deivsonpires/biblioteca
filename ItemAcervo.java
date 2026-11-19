package com.bibliotecaigor.biblioteca_igor;

public abstract class ItemAcervo {
    private String codigo;
    private String titulo;
    private int anoPublicacao;
    private boolean disponivel;

    public ItemAcervo(String codigo, String titulo, int anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true; 
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public boolean emprestarItem() {
        if (this.disponivel) {
            this.disponivel = false;
            return true;
        }
        return false;
    }

    public void devolverItem() {
        this.disponivel = true;
    }

    public abstract void exibirDetalhes();
}