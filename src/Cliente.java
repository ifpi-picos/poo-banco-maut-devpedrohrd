public class Cliente {
    private String nomeCliente;
    private String cpfCliente;
    private String dataNascimento;
    private Endereco endereco;

    public Cliente(String nomeCliente, String cpfCliente, String dataNascimento, Endereco endereco) {
        this.endereco = endereco;
        this.cpfCliente = cpfCliente;
        this.dataNascimento = dataNascimento;
        this.nomeCliente = nomeCliente;

    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setDataNascimento(String dataNascimento) {
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