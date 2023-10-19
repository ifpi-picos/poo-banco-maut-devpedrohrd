import java.util.ArrayList;
import java.util.List;

abstract public class Conta {
    private final String numeroConta;
    private final String numeroAgencia;
    protected double saldo;
    private Cliente cliente;
    private List<Transacao> transacoes;
    public static int qtdContas;

    // Construtor das contas
    public Conta(String numeroConta, String numeroAgencia, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.cliente = cliente;
        this.saldo = 0.0;
        this.transacoes = new ArrayList<>();
        this.qtdContas++;

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
        this.saldo -= valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    // Método de deposito
    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Valor depositado: R$" + valor);
            transacoes.add(new Transacao("Deposito", valor));
            this.enviarNotificacao("Deposito", valor);
            return true;
        }
        System.out.println("Nao foi possivel realizar o deposito !!");
        return false;
    }

    // Método de saque
    public boolean sacar(double valor) {
        if (valor < saldo) {
            saldo -= valor;
            System.out.println("Valor sacado: R$" + valor);
            transacoes.add(new Transacao("Saque", valor));
            this.enviarNotificacao("Saque", valor);
            return true;
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente !!");
            return false;
        }
        System.out.println("Nao foi possivel realizar o saque !!");
        return false;
    }

    // Método de transferência
    public boolean transferir(Conta contaDestino, double valor) {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
            transacoes.add(new Transacao("Transferencia", valor));
            this.enviarNotificacao("Transferencia", valor);
            return true;
        }
        return false;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void exibirTransacoes() {
        System.out.println("\n***** Extrato de Transacoes da conta " + getNumeroConta() + " *****");
        for (Transacao conta : transacoes) {
            System.out.println(
                    "Tipo ->" + conta.getDescricao() +
                            "\nValor ->" + conta.getValor() +
                            "\nData ->" + conta.getData());
            System.out.println("\n************");
        }
    }

    public void enviarNotificacao(String operacao, double valor) {
        new Notificacao().enviarEmail(operacao, valor);
    }
}
