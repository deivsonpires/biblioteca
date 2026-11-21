package com.bibliotecaigor.biblioteca_igor;

public class Livro extends ItemAcervo {
    private String isbn;
    private Autor autor; 
    private GeneroLivro genero;

    public Livro(String codigo, String titulo, int anoPublicacao, String isbn, Autor autor, GeneroLivro genero) {
        super(codigo, titulo, anoPublicacao);
        this.isbn = isbn;
        this.autor = autor;
        this.genero = genero;
    }

    public String getIsbn() {
        return isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public GeneroLivro getGenero() {
        return genero;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("--- Livro ---");
        System.out.println("Título: " + getTitulo() + " (Cód: " + getCodigo() + ")");
        System.out.println("Autor: " + autor.getNome()); // Usa o objeto associado
        System.out.println("Gênero: " + genero.getDescricao());
        System.out.println("Ano: " + getAnoPublicacao());
        System.out.println("ISBN: " + getIsbn());
        System.out.println("Disponível: " + (isDisponivel() ? "Sim" : "Não"));
    }
}