# Cadastro de Funcionários

Exercício em Java utilizando `List`, `Stream API`, `BigDecimal` e `LocalDate` para manipulação de uma lista de funcionários (inserção, remoção, agrupamento, filtros e formatação de dados).

## Estrutura do projeto

```
.
├── src/
│   ├── Main.java
│   └── classes/
│       ├── Funcionario.java
|       └── Pessoa.java
```

> Ajuste os caminhos abaixo caso sua estrutura de pastas seja diferente (por exemplo, se não usar uma pasta `src`).

## Pré-requisitos

- JDK instalado (Java 11 ou superior). Verifique com:
  ```bash
  java -version
  javac -version
  ```
- VSCode com a extensão **Extension Pack for Java** (da Microsoft), que já traz suporte a compilação e execução integradas.

## Como executar pelo VSCode

1. Abra a pasta do projeto no VSCode (`File > Open Folder...`).
2. Certifique-se de que a extensão **Extension Pack for Java** está instalada e ativa.
3. Abra o arquivo `Main.java`.
4. Clique em **Run** (ícone de play) que aparece acima do método `public static void main`, ou pressione `F5`.
5. A saída será exibida no painel **Terminal** ou **Debug Console** do VSCode.

## Como executar pelo terminal

Caso prefira compilar e rodar manualmente (útil também para confirmar que funciona fora do VSCode antes de subir pro GitHub):

```bash
# a partir da raiz do projeto, supondo a estrutura src/Main.java e src/classes/Funcionario.java

# 1. Compilar
javac -d bin src/Main.java src/classes/Funcionario.java

# 2. Executar
java -cp bin Main
```

- `-d bin` gera os `.class` compilados dentro da pasta `bin/`.
- `-cp bin` diz à JVM para procurar as classes compiladas dentro de `bin/`.

Se todo o código estiver em um único diretório (sem separar em `src`/`classes`), simplifique para:

```bash
javac *.java classes/*.java
java Main
```

## Observações

- O projeto usa `BigDecimal` para valores monetários (evita erros de arredondamento comuns com `double`/`float`).
- Datas são manipuladas com `LocalDate` e formatadas no padrão `dd/MM/yyyy`.
- Alguns itens do exercício (3.9 a 3.12) ainda não foram implementados — aparecem apenas como comentários no código, indicando os próximos passos.

## Licença

Projeto de estudo pessoal, sem licença específica definida.
