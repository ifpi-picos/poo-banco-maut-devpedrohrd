import java.time.LocalDate;

public class Cliente {
    private String nomeCliente;
    private final String cpfCliente;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private Conta conta;

    public Cliente(String nomeCliente, String cpfCliente, LocalDate dataNascimento, Endereco endereco) {
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getCpfCliente() {
        return this.cpfCliente;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String exibirEndereco() {
        return endereco.getRua() + " ,"
                + endereco.getBairro() + " ," + endereco.getNumero() + " ," + endereco.getCidade() + " ,"
                + endereco.getEstado() + " ," + endereco.getCep();
    }
}