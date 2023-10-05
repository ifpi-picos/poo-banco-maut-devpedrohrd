import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String numeroAgencia;
    private String numeroConta;
    private double saldo;
    private Cliente cliente;
    private List<Transacao> transacoes;
    private Sistema dadosContas;

    public Conta(String numeroAgencia, String numeroConta, Cliente cliente) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
    }

    public Sistema getDadosClientes() {
        return dadosContas;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
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

    public void transferir(String numeroConta, double valor) {
        if (dadosContas.procuraNumeroConta(numeroConta) != null) {
            if (valor <= 0 || valor > saldo) {
                System.err.printf("%s: %f\n", "Valor inválido!", valor);
            } else {
                saldo -= valor;
                notificacao("transferencia", valor);
                Conta contaDestino = dadosContas.procuraNumeroConta(numeroConta);
                contaDestino.depositar(valor);
                transacoes.add(new Transacao("Transferencia para a conta " + contaDestino.numeroConta, valor));
            }

        } else {
            System.err.printf("%s: %s\n", "A conta destinatario nao existe.", numeroConta);
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

    public void exibirInfoCliente() {
        System.out.println("\nNome ->" + cliente.getNomeCliente() + "\nCPF ->" + cliente.getCpfCliente()
                + "\nNumero da conta ->" + numeroConta + "\nNumero da agencia ->" + numeroAgencia + "\nEndereco ->"
                + cliente.exibirEndereco());
    }
}
