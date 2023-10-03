public class Endereco {
    private String rua;
    private String bairro;
    private String cep;
    private String cidade;
    private String numero;

    public Endereco(String rua, String bairro, String cep, String cidade, String numero) {
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getNumero() {
        return numero;
    }

    public String getRua() {
        return rua;
    }

    public void exibirEndereco() {
        System.out.println("\nCEP -> " + this.getCep() + "\nRua -> " + getRua() + "\nBairro -> " + getBairro()
                + "Cidade -> " + getCidade() + "Numero -> " + getNumero());
    }
}
