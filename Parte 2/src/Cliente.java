import java.time.LocalDate;

public class Cliente {
    private String nome;
    private LocalDate dataNascimento;
    private final String cpf;
    private Endereco endereco;
    private Conta conta;

    public Cliente(String nome, LocalDate dataNascimento, String cpf, Endereco endereco) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Conta getConta() {
        return conta;
    }

}
