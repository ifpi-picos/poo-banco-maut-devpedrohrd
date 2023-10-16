import java.time.LocalDate;

public class Cliente {
    private String nome;
    private LocalDate dataNascimento;
    private final String cpf;
    private Endereco endereco;
    private Conta conta;

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

    public Conta getConta() {
        return conta;
    }

    public void infoCliente() {
        System.out.println("\nNome ->" + getNome() +
                "\nCPF ->" + getCpf() +
                "\nNumeroConta ->" + getConta().getNumeroConta()
                + "\nNumeroAgencia ->" + getConta().getNumeroAgencia()
                + "\nSaldo ->" + getConta().getSaldo());

        if (getEndereco() != null) {
            System.out.println("\nEndereco ->" + getEndereco());
        }
    }

}
