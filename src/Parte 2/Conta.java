import java.util.ArrayList;
import java.util.List;

public class Conta {
    private final String numeroConta;
    private final String numeroAgencia;
    private double saldo;
    private Cliente cliente;
    private List<Transacao> transacoes;

    public Conta(String numeroConta, String numeroAgencia) {
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.saldo = 0.0;
        this.transacoes = new ArrayList<>();
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

    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito realizado com sucesso !!");
            transacoes.add(new Transacao("Deposito", valor));
            notificacao("realizou um deposito ", valor);
            return true;
        }
        System.out.println("Nao foi possivel realizar o deposito !!");
        return false;
    }

    public boolean sacar(double valor) {
        if (valor < saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso !!");
            transacoes.add(new Transacao("Saque", valor));
            notificacao("realizou um saque ", valor);
            return true;
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente !!");
            return false;
        }
        System.out.println("Nao foi possivel realizar o saque !!");
        return false;
    }

    public boolean transferir(Conta contaDestino, double valor) {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
            transacoes.add(new Transacao("Transferencia", valor));
            notificacao("realizou uma transferencia ", valor);
            return true;
        }
        return false;
    }

    public void notificacao(String desc, double valor) {
        System.out.println("O cliente " + desc + "de R$" + valor);
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void exibirTransacoes() {
        System.out.println("\n***** Historico de Transacoes *****");
        for (Transacao conta : transacoes) {
            System.out.println(
                    "Tipo ->" + conta.getDescricao() +
                            "\nValor ->" + conta.getValor() +
                            "\nData ->" + conta.getData());
            System.out.println("\n************");
        }
    }

}
