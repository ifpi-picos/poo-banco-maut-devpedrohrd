public class Endereco {
    private String rua;
    private String bairro;
    private String cep;
    private String cidade;
    private String numero;
    private String estado;

    public Endereco(String rua, String bairro, String cep, String cidade, String numero, String estado) {
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.numero = numero;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public String getNumero() {
        return numero;
    }

    public String getRua() {
        return rua;
    }

    public String getEndereco() {
        return getRua() + "," + getBairro() + "," + getCidade() + "," + getNumero() + "," + getEstado() + ","
                + getCep();
    }
}
