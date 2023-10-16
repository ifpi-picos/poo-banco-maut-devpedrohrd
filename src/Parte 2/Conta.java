public class Conta {
    private final String numeroConta;
    private final String numeroAgencia;
    private double saldo;
    private Cliente cliente;

    public Conta(String numeroConta, String numeroAgencia) {
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.saldo = 0.0;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
