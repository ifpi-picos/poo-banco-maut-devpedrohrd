import java.time.LocalDate;

public class Cliente {
    private String nome;
    private LocalDate dataNascimento;
    private final String cpf;
    private Endereco endereco;

    public Cliente(String nome, LocalDate dataNascimento, String cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
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
}
