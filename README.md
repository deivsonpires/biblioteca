# Sistema de Gerenciamento de Biblioteca

Sistema de gerenciamento de acervo, leitores e empréstimos em **Java**, desenvolvido para aplicar os pilares da **Programação Orientada a Objetos (POO)**.

---

## Conceitos de POO Aplicados

* **Abstração:** Classes base (`Pessoa`, `Leitor` e `ItemAcervo`) definem contratos e comportamentos compartilhados.
* **Herança:** Especialização via hierarquias (`Autor` e `Leitor` $\rightarrow$ `Pessoa`; `Aluno` e `Professor` $\rightarrow$ `Leitor`; `Livro` e `Revista` $\rightarrow$ `ItemAcervo`).
* **Polimorfismo:** Sobrescrita (`@Override`) para regras específicas de prazo, limite de itens, restrição de empréstimo em revistas e exibição de detalhes.
* **Encapsulamento:** Atributos privados com acesso via getters/setters e validações internas (como formato de CPF e disponibilidade do item).
* **Associação e Composição:** Relacionamentos diretos entre `Livro` e `Autor`, `Emprestimo` com `Leitor` e `ItemAcervo`, centralizados em `Biblioteca`.
* **Enumerações (`Enum`):** Padronização de estados e categorias com `GeneroLivro` e `StatusEmprestimo`.

---

## Estrutura do Projeto

Todas as classes pertencem ao pacote `com.bibliotecaigor.biblioteca_igor`:

```text
src/
   ├── Pessoa.java             # Classe abstrata base (nome, CPF e validação)
   ├── Autor.java              # Subclasse de Pessoa com biografia
   ├── Leitor.java             # Classe abstrata base para usuários da biblioteca
   ├── Aluno.java              # Subclasse de Leitor (matrícula, prazo de 15 dias)
   ├── Professor.java          # Subclasse de Leitor (departamento, prazo de 30 dias)
   ├── ItemAcervo.java         # Classe abstrata base para itens catalogados
   ├── Livro.java              # Subclasse de ItemAcervo (ISBN, Autor, Gênero)
   ├── Revista.java            # Subclasse de ItemAcervo (ISSN, Volume, consulta local)
   ├── GeneroLivro.java        # Enum com os gêneros literários disponíveis
   ├── StatusEmprestimo.java   # Enum com estados (ATIVO, CONCLUIDO, ATRASADO)
   ├── Emprestimo.java         # Registro de empréstimo, prazos e cálculo de multa
   ├── Biblioteca.java         # Controlador principal de cadastros, empréstimos e devoluções
   └── SistemaBiblioteca.java  # Classe principal (main) com cenários de demonstração
```

---

## Regras de Negócio

### Perfis de Leitores
| Perfil | Limite de Itens | Prazo | Identificação |
| :--- | :---: | :---: | :--- |
| **Aluno** | 3 itens | 15 dias | Matrícula |
| **Professor** | 10 itens | 30 dias | Departamento |

### Acervo, Empréstimos e Multas
* **Livros:** Disponíveis para empréstimo conforme disponibilidade no acervo.
* **Revistas:** Apenas **consulta local** (empréstimo bloqueado em `emprestarItem()`).
* **Validação:** Exige leitor e item válidos, item disponível e leitor dentro do limite de empréstimos ativos.
* **Atrasos:** Na devolução, se a data atual ultrapassar a prevista, o status muda para `ATRASADO` e aplica-se a multa:

$$\text{Multa} = \text{Dias de Atraso} \times R\$\ 1,50$$

---

## Como Executar

### Pré-requisitos
* **JDK 8** ou superior instalado.

### Via Terminal
A partir da pasta raiz do projeto (onde está a pasta `src/`):

```bash
# Compila os arquivos gerando a estrutura do pacote em "out"
javac -d out src/*.java

# Executa a classe principal
java -cp out com.bibliotecaigor.biblioteca_igor.SistemaBiblioteca
```

### Via IDE
Abra o projeto no **IntelliJ IDEA**, **Eclipse** ou **VS Code** e execute o método `main` de `SistemaBiblioteca.java`.

---

## Cenário de Demonstração

A execução de `SistemaBiblioteca` valida automaticamente:
* Cadastro e listagem de autores, leitores (`Aluno` e `Professor`) e itens (`Livro` e `Revista`).
* Empréstimos válidos e bloqueios (livro já emprestado e tentativa de empréstimo de revista).
* Devolução de itens com atualização de disponibilidade e listagem de empréstimos ativos.