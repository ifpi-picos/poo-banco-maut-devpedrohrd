import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String numeroAgencia;
    private String numeroConta;
    private double saldo;
    private Cliente cliente;
    private List<Transacao> transacoes;

    public Conta(String numeroAgencia, String numeroConta, Cliente cliente, Transacao transacao) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        System.out.println("O saldo atual do cliente " + cliente.getNomeCliente() + " é R$" + saldo);
        return saldo;
    }

    public boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            System.out.println("Digite um valor inteiro positivo !");
            return false;
        } else {
            saldo -= valor;
            notificacao("saque", valor);
            transacoes.add(new Transacao("Saque", -valor));
            return true;
        }
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Digite um valor inteiro positivo !!");
        } else {
            saldo += valor;
            notificacao("deposito", valor);
            transacoes.add(new Transacao("Deposito", valor));
        }
    }

    public boolean transferir(Conta destino, double valor) {

        if (valor > 0 && valor < saldo) {
            saldo -= valor;
            destino.depositar(valor);
            notificacao("transferencia", valor);
            transacoes.add(new Transacao("Transferencia para " + destino.numeroConta, -valor));
            destino.transacoes.add(new Transacao("Transferencia de " + numeroConta, valor));
            return true;
        } else {
            System.out.println("Saldo insuficiente para realizar transferencia!!");
            System.out.println("O cliente " + cliente.getNomeCliente() + " tentou transferir R$" + valor);
            System.out.println("Digite um valor abaixo do saldo!");
            return false;
        }
    }

    public void exibirTransacoes() {
        for (Transacao conta : transacoes) {
            System.out.println("*************");
            System.out.println(
                    "\nTipo ->" + conta.getDescricao() +
                            "\nValor ->" + conta.getValor() +
                            "\nData ->" + conta.getData() + "\n");
        }
    }

    public void notificacao(String desc, double val) {
        System.out.println("O cliente " + getNumeroConta() + " realizou um(a) " + desc + " de R$" + val);
    }
}
