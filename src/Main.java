
import classes.Funcionario;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {
        static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        // 3. Deve conter uma classe Principal para executar as seguintes ações:
        public static void main(String[] args) {

                // 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela
                // acima.
                List<Funcionario> funcionarios = new ArrayList<>();

                funcionarios.add(
                                new Funcionario("Maria", LocalDate.parse("18/10/2000", formatter),
                                                new BigDecimal("2009.44"),
                                                "Operador"));
                funcionarios.add(
                                new Funcionario("João", LocalDate.parse("12/05/1990", formatter),
                                                new BigDecimal("2284.38"),
                                                "Operador"));
                funcionarios.add(new Funcionario("Caio", LocalDate.parse("02/05/1961", formatter),
                                new BigDecimal("9836.14"),
                                "Coordenador"));
                funcionarios.add(new Funcionario("Miguel", LocalDate.parse("14/10/1988", formatter),
                                new BigDecimal("19119.88"),
                                "Diretor"));
                funcionarios.add(new Funcionario("Alice", LocalDate.parse("05/01/1995", formatter),
                                new BigDecimal("2234.64"),
                                "Recepcionista"));
                funcionarios.add(new Funcionario("Heitor", LocalDate.parse("19/11/1999", formatter),
                                new BigDecimal("1582.72"),
                                "Operador"));
                funcionarios.add(new Funcionario("Arthur", LocalDate.parse("31/03/1993", formatter),
                                new BigDecimal("4071.84"),
                                "Contador"));
                funcionarios.add(
                                new Funcionario("Laura", LocalDate.parse("08/07/1994", formatter),
                                                new BigDecimal("3017.45"),
                                                "Gerente"));
                funcionarios.add(new Funcionario("Heloísa", LocalDate.parse("24/05/2003", formatter),
                                new BigDecimal("1606.85"),
                                "Eletricista"));
                funcionarios.add(
                                new Funcionario("Helena", LocalDate.parse("02/09/1996", formatter),
                                                new BigDecimal("2799.93"),
                                                "Gerente"));

                // 3.2 – Remover o funcionário “João” da lista.
                funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));
                // 3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
                // • informação de data deve ser exibido no formato dd/mm/aaaa;
                // • informação de valor numérico deve ser exibida no formatado com separador de
                // milhar como ponto e decimal como vírgula.
                funcionarios.forEach(funcionario -> {
                        String nome = funcionario.getNome();
                        String dataNascimento = funcionario.getDataNascimento().format(formatter);
                        String salario = currencyFormatter.format(funcionario.getSalario());
                        String funcao = funcionario.getFuncao();
                        System.out.println(String.format("%s - %s - %s - %s", nome, dataNascimento, salario, funcao));
                });
                // 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista
                // de funcionários com novo valor.
                funcionarios.forEach(funcionario -> {
                        BigDecimal aumento = funcionario.getSalario().multiply(new BigDecimal("0.10"));
                        funcionario.setSalario(funcionario.getSalario().add(aumento));
                });
                // 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função”
                // e o valor a “lista de funcionários”.
                Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                                .collect(Collectors.groupingBy(Funcionario::getFuncao));
                // 3.6 – Imprimir os funcionários, agrupados por função.
                funcionariosPorFuncao.forEach((funcao, lista) -> {
                        System.out.println(funcao + ":");
                        lista.forEach(f -> System.out.println("  - " + f.getNome()));
                });
                // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
                int[] mesesAniversario = { 10, 12 };
                funcionarios.stream()
                                .filter(funcionario -> Arrays.stream(mesesAniversario)
                                                .anyMatch(mes -> funcionario.getDataNascimento()
                                                                .getMonthValue() == mes))
                                .forEach(funcionario -> System.out.println("Aniversariante: " + funcionario.getNome()
                                                + " (mês " + funcionario.getDataNascimento().getMonthValue() + ")"));
                // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e
                // idade.
                // 3.10 – Imprimir a lista de funcionários por ordem alfabética.
                // 3.11 – Imprimir o total dos salários dos funcionários.
                // 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando
                // que o salário mínimo é R$1212.00.

        }
}
