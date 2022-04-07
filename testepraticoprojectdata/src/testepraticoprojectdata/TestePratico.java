
package testepraticoprojectdata;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class TestePratico {
    public static void main(String[] args) {
        
        //criando lista e adicionando funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), "Operador", new BigDecimal("2009.44")));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), "Operador", new BigDecimal("2284.38")));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 12), "Coordenador", new BigDecimal("9836.14")));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), "Diretor", new BigDecimal("19119.88")));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), "Recepcionista", new BigDecimal("2234.68")));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), "Operador", new BigDecimal("1582.72")));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), "Contador", new BigDecimal("4071.84")));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), "Gerente", new BigDecimal("3017.45")));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), "Eletricista", new BigDecimal("1606.85")));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), "Gerente", new BigDecimal("2799.93")));
        
        //imprimindo nome dos funcionários
        System.out.println("Nomes dos funcionários:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome());
        }
        System.out.println("############################");

        //removendo o funcionário João
        System.out.println("Removendo funcionário com nome 'João'");
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));
        System.out.println("Removido com sucesso!");

        System.out.println("############################");

        //imprimindo lista atualizada dos nomes dos funcionários
        System.out.println("Nomes dos funcionários:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome());
        }

        System.out.println("############################");

        //imprimindo informações do funcionário
        System.out.println("Informações dos funcionários:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.toString());
        }

        //aumentando o salário dos funcionários em 10%
        System.out.println("############################");
        System.out.println("Funcionário recebeu aumento de 10%");
        for (Funcionario funcionario : funcionarios) {
            funcionario.recebeAumento(new BigDecimal("1.10"));
        }

        System.out.println("############################");

        //imprimindo informações do funcionários com salário atualizado
        System.out.println("Informações dos funcionários:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.toString());
        }

        System.out.println("############################");

        //criando MAP e separando/imprimindo funcionários por função
        System.out.println("Funcionários por função:");
        Map<String, List<Funcionario>> map;
        map = funcionarios.stream().collect(groupingBy(Funcionario::getFuncao));
        for (String funcao : map.keySet()) {
            System.out.println(funcao);
            for (Funcionario funcionario : map.get(funcao)) {
                System.out.println("\t" + funcionario.getNome());
            }
        }

        System.out.println("############################");

        //mostrando os funcionários que fazem aniversário no mês 10 e 12
        System.out.println("Funcionários que fazem aniversário no mês 10 e 12:");
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDataNascimento().getMonthValue() == 10 || funcionario.getDataNascimento().getMonthValue() == 12) {
                System.out.println(funcionario.getNome());
            }
        }

        System.out.println("############################");

        //imprimindo funcionário com maior salário
        System.out.println("Funcionário com o maior salário:");
        Funcionario maior_salario = funcionarios.stream().max(Comparator.comparing(Funcionario::getSalario)).get();
        System.out.println(maior_salario.getNome() + " - " + maior_salario.getSalarioFormatado());

        System.out.println("############################");

        //imprimindo funcionários por ordem alfabética
        System.out.println("Funcionários em ordem alfabetica:");
        funcionarios.stream().sorted(Comparator.comparing(Funcionario::getNome)).forEach(System.out::println);

        System.out.println("############################");

        //imprimindo o total dos salários dos funcionários
        System.out.println("Total de salários dos funcionarios:");
        Double soma = funcionarios.stream().mapToDouble(funcionario -> funcionario.getSalario().doubleValue()).sum();
        System.out.println(NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(soma));

        System.out.println("############################");

        //imprimindo quantos salários mínimos ganham cada funcionário
        System.out.println("Quantos salários mínimos tem cada funcionário.");
        Double SALARIO_MINIMO = 1212.00;
        for (Funcionario funcionario : funcionarios) {
            Double salario = funcionario.getSalario().doubleValue();
            Double qts_salarios_minimos = salario / SALARIO_MINIMO;
            qts_salarios_minimos = Math.floor(qts_salarios_minimos * 100) / 100;
            System.out.println(funcionario.getNome() + " recebe " + qts_salarios_minimos + " salários mínimos.");
        }


    }
}
