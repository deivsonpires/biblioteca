/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.bibliotecaigor.biblioteca_igor;



/**
 *
 * @author leonardo :o
 * 
 */
public class SistemaBiblioteca {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Autor autor1 = new Autor("Igor", "11122233344", "Autor de POO");
        Autor autor2 = new Autor("Celso", "55566677788", "Autor de Diagrama de Sistemas");
        Autor autor3 = new Autor("Fabio", "99988877766", "Autor de Arquitetura de Computadores");

        Leitor a1 = new Aluno("Leonardo", "12345678900", "L001", "A001");
        Leitor p1 = new Professor("Professor Igor", "00987654321", "L002", "Ciência da Computação");
        
        biblioteca.cadastrarLeitor(a1);
        biblioteca.cadastrarLeitor(p1);

        ItemAcervo i1 = new Livro("C001", "POO", 1997, "978-8532511010", autor1, GeneroLivro.TECNICO);
        ItemAcervo i2 = new Livro("C002", "Diagrama de Sistemas", 1954, "978-8533613379", autor2, GeneroLivro.TECNICO);
        ItemAcervo i3 = new Livro("C003", "Arquitetura de Computadores", 2016, "978-8543005676", autor3, GeneroLivro.TECNICO);
        ItemAcervo i4 = new Revista("C004", "Revista Nature", 2023, "0028-0836", 560);

        biblioteca.cadastrarItem(i1);
        biblioteca.cadastrarItem(i2);
        biblioteca.cadastrarItem(i3);
        biblioteca.cadastrarItem(i4);
        biblioteca.listarAcervo();
        biblioteca.listarLeitores();

        // aqui estou simulando as tentativas de emprestimo
        
        // essa daqui é provavel que funcione por conta do limite de dias
        biblioteca.realizarEmprestimo("L001", "C001");

        biblioteca.realizarEmprestimo("L002", "C003");

        biblioteca.realizarEmprestimo("L001", "C002");

        // essa daqui é feita para falhar
        biblioteca.realizarEmprestimo("L001", "C002");
        
        biblioteca.realizarEmprestimo("L001", "C004");
        
        // depois disso vou listar e simular as devoluções
        biblioteca.listarEmprestimosAtivos();
        
        // por conta do jeito que meu sistema funciona estou assumindo que a
        // devolução é legitima
        biblioteca.realizarDevolucao("C001");

        // aqui eu simulei um atraso para testar a multa
        biblioteca.realizarDevolucao("C003");

        biblioteca.listarAcervo();
        
        biblioteca.listarEmprestimosAtivos();

    }
}
