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

    public String getNumConta() {
        return conta.getNumeroConta();
    }

    public String getNumAgencia() {
        return conta.getNumeroAgencia();
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getNomeCliente() {
        return nomeCliente;
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