package testepraticoprojectdata;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Funcionario extends Pessoa {
    private String funcao;
    private BigDecimal salario;

    public Funcionario(String nome, LocalDate dataNascimento, String funcao, BigDecimal salario) {
        super(nome, dataNascimento);
        this.funcao = funcao;
        this.salario = salario;
    }

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

    public String getSalarioFormatado() {
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(salario);
    }

    @Override
    public String toString() {
        return super.toString() + ", Função: " + funcao + ", Salário: " + getSalarioFormatado();
    }

    public void recebeAumento(BigDecimal aumento) {
        this.salario = this.salario.multiply(aumento);
    }
}