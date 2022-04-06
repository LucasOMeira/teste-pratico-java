package testepraticoprojectdata;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

//criando classe funcionario extendendo a classe pessoa
public class Funcionario extends Pessoa {
    private String funcao;
    private BigDecimal salario;
    
    //definindo objeto funcionário e seus atributos
    public Funcionario(String nome, LocalDate dataNascimento, String funcao, BigDecimal salario) {
        super(nome, dataNascimento);
        this.funcao = funcao;
        this.salario = salario;
    }

    //getters e setters
    public String getFuncao() {
        return funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
    
    //formatando saída do salário
    public String getSalarioFormatado() {
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(salario);
    }

    //formatando saída de informação do funcionário
    @Override
    public String toString() {
        return super.toString() + ", Função: " + funcao + ", Salário: " + getSalarioFormatado();
    }
    
    //criando método de aumento de salário
    public void recebeAumento(BigDecimal aumento) {
        this.salario = this.salario.multiply(aumento);
    }
}
