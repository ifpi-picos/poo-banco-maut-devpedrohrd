import java.time.LocalDate;

public class Cliente {
    private String nomeCliente;
    private String cpfCliente;
    private LocalDate dataNascimento;
    private Endereco endereco;

    public Cliente(String nomeCliente, String cpfCliente, Endereco endereco) {
        this.endereco = endereco;
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
        this.dataNascimento = LocalDate.of(0, 0, 0);

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

    public void EnderecoCliente() {
        endereco.exibirEndereco();
    }
}