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
        return saldo;
    }

    public void sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            System.out.println("Digite um valor inteiro positivo !");
        } else {
            saldo += valor;
            System.out.println("Saque realizado com sucesso!!");
            System.out.println("O cliente " + cliente.getNomeCliente() + " sacou R$" + valor + "!");
            transacoes.add(new Transacao("Saque", valor));
        }
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Digite um valor inteiro positivo !!");
        } else {
            saldo += valor;
            System.out.println("Deposito realizado com sucesso!!");
            System.out.println("O cliente " + cliente.getNomeCliente() + " depositou R$" + valor + "!");
            transacoes.add(new Transacao("Deposito", valor));
        }
    }

    public void transferir(String numeroConta, double valor) {
        if (valor > 0 && valor < saldo) {
            saldo -= valor;
            System.out.println("Transferencia realizada com sucesso!!");
            transacoes.add(new Transacao("Transferencia", valor));
        } else {
            System.out.println("Nao foi possivel realizar a transferencia !!");
        }
    }

    public void exibirTransacoes() {
        for (Transacao conta : transacoes) {
            System.out.println(
                    "\nTipo ->" + conta.getDescricao() +
                            "\nValor ->" + conta.getValor() +
                            "\nData ->" + conta.getData());
        }
    }
}
