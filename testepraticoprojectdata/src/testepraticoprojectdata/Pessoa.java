package testepraticoprojectdata;
import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    
    //criando pessoas e seus atributos
    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    //getters e setters
    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    //polimorfismo
    public String toString() {
        return nome + ", " + dataNascimento.getDayOfMonth() + "/" + dataNascimento.getMonthValue() + "/" + dataNascimento.getYear();
    }
}
