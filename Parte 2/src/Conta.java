import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    private final String numeroConta;
    private final String numeroAgencia;
    protected double saldo;
    private Cliente cliente;
    private List<Transacao> transacoes;
    public static int qtdContas;
    private Notificacao notificacao;

    // Construtor das contas
    public Conta(String numeroConta, String numeroAgencia, Cliente cliente, Notificacao notificacao) {
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
        this.qtdContas++;
        this.notificacao = notificacao;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public Notificacao getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
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

    public void setSaldo(double valor) {
        this.saldo = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    // Método de deposito
    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            transacoes.add(new Transacao("Deposito", valor));
            notificacao.enviarNotificacao("Deposito", valor);
            return true;
        }
        System.out.println("Nao foi possivel realizar o deposito !!");
        return false;
    }

    // Método de saque
    public abstract boolean sacar(double valor);

    // Método de transferência
    public abstract boolean transferir(Conta contaDestino, double valor);

    public void exibirTransacoes() {
        System.out.println("\n***** Extrato de Transacoes da conta " + getNumeroConta() + " *****");
        for (Transacao conta : transacoes) {
            System.out.println(
                    "Tipo ->" + conta.getDescricao() +
                            "\nValor -> R$" + conta.getValor() +
                            "\nData ->" + conta.getData());
            System.out.println("\n************");
        }
    }
}
