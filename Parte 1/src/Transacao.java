import java.util.Date;

public class Transacao {
    private String descricao;
    private double valor;
    private Date data;

    public Transacao(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = new Date();
    }

    public Date getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

}
