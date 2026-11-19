# Sistema de Gerenciamento de Biblioteca

Sistema de gerenciamento de acervo, leitores e empréstimos desenvolvido em **Java**, projetado para aplicar de forma prática os principais pilares e boas práticas da **Programação Orientada a Objetos (POO)**.

---

## Conceitos de POO Aplicados

* **Abstração:** Utilização das classes abstratas `Pessoa`, `Leitor` e `ItemAcervo` para definir contratos e comportamentos base compartilhados entre entidades semelhantes.
* **Herança:** Especialização de entidades através de hierarquias bem definidas (`Autor` e `Leitor` estendem `Pessoa`; `Aluno` e `Professor` estendem `Leitor`; `Livro` e `Revista` estendem `ItemAcervo`).
* **Polimorfismo:** Sobrescrita de métodos (`@Override`) para adaptar regras de negócio por tipo de entidade, como prazos e limites de empréstimo (`getLimiteDiasEmprestimo()`, `getLimiteItensEmprestimo()`), restrição de empréstimo em revistas (`emprestarItem()`) e exibição customizada (`exibirDetalhes()`, `getIdentificacao()`).
* **Encapsulamento:** Atributos privados com acesso controlado por métodos públicos e validações internas (como a validação de formato de CPF em `Pessoa` e controle de disponibilidade em `ItemAcervo`).
* **Associação e Composição:** Relacionamento direto entre objetos, como `Livro` associado a um `Autor`, `Emprestimo` conectando um `Leitor` a um `ItemAcervo`, e `Biblioteca` atuando como fachada centralizadora das coleções.
* **Enumerações (`Enum`):** Uso de `GeneroLivro` e `StatusEmprestimo` para garantir segurança de tipos e padronização de estados no sistema.

---

## Estrutura do Projeto

Todas as classes pertencem ao pacote `com.bibliotecaigor.biblioteca_igor`:

```text
src/
└── com/
    └── bibliotecaigor/
        └── biblioteca_igor/
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

### 1. Perfis de Leitores
| Perfil | Limite de Itens Simultâneos | Prazo de Devolução | Identificação Específica |
| :--- | :---: | :---: | :--- |
| **Aluno** | 3 itens | 15 dias | Número de Matrícula |
| **Professor** | 10 itens | 30 dias | Departamento |

### 2. Políticas do Acervo
* **Livros:** Podem ser emprestados normalmente caso estejam disponíveis no acervo. Ao serem emprestados, ficam indisponíveis até a realização da devolução.
* **Revistas:** Destinadas exclusivamente à **consulta local**. Tentativas de empréstimo são bloqueadas polimorficamente pelo método `emprestarItem()`.

### 3. Empréstimos, Devoluções e Multas
* Um empréstimo só é efetivado se o leitor e o item existirem, se o leitor não tiver atingido seu limite de empréstimos ativos e se o item estiver disponível.
* Na devolução, o sistema compara a data real de entrega (`LocalDate.now()`) com a data prevista.
* Caso haja atraso, o status do empréstimo passa para `ATRASADO` e a multa é calculada conforme a fórmula:

$$\text{Multa} = \text{Dias de Atraso} \times R\$\ 1,50$$

---

## Como Executar

### Pré-requisitos
* **Java Development Kit (JDK)** versão 8 ou superior instalado e configurado no `PATH` (o projeto utiliza a API `java.time.LocalDate`).

### Executando via Terminal

1. Navegue até o diretório raiz dos arquivos fonte (`src`):
   ```bash
   cd src
   ```

2. Compile todos os arquivos Java do pacote:
   ```bash
   javac com/bibliotecaigor/biblioteca_igor/*.java
   ```

3. Execute a classe principal `SistemaBiblioteca`:
   ```bash
   java com.bibliotecaigor.biblioteca_igor.SistemaBiblioteca
   ```

### Executando via IDE
Importe o projeto em sua IDE de preferência (**IntelliJ IDEA**, **Eclipse** ou **VS Code** com *Extension Pack for Java*), localize a classe `SistemaBiblioteca.java` e execute o método `main`.

---

## Cenário de Demonstração (`SistemaBiblioteca`)

Ao rodar a aplicação, o método `main` executa automaticamente um fluxo completo de testes que valida:
1. Cadastro de autores, leitores (`Aluno` e `Professor`) e itens do acervo (`Livro` e `Revista`).
2. Listagem inicial do acervo e dos leitores cadastrados.
3. Empréstimos bem-sucedidos para aluno e professor.
4. Bloqueio de empréstimo de um livro já emprestado (indisponível).
5. Bloqueio de empréstimo de uma revista (apenas consulta local).
6. Listagem de empréstimos ativos, devolução de itens e atualização automática da disponibilidade do acervo.