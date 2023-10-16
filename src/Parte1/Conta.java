import java.util.ArrayList;
import java.util.List;

public class Conta {
    private final String numeroAgencia;
    private final String numeroConta;
    private double saldo;
    private String tipoConta;
    private Cliente cliente;
    private List<Transacao> transacoes;
    private ContaCorrente corrente;
    private ContaPoupanca poupanca;

    public Conta(String numeroAgencia, String numeroConta, Cliente cliente, String tipoConta) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
        this.tipoConta = tipoConta;
        this.corrente = getCorrente();

        if ("c".equals(tipoConta)) {
            corrente = new ContaCorrente(this);
        } else if ("c".equals(tipoConta)) {
            poupanca = new ContaPoupanca(this);
        }
    }

    public ContaCorrente getCorrente() {
        return corrente;
    }

    public ContaPoupanca getPoupanca() {
        return poupanca;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Digite um valor positivo !");
            return false;
        }
        if (saldo < valor) {
            System.out.println("Saldo insuficiente !!");
            return false;
        }
        saldo -= valor;
        transacoes.add(new Transacao("Saque", valor));
        return true;
    }

    public boolean depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Digite um valor inteiro positivo !!");
            return false;
        } else {
            saldo += valor;
            transacoes.add(new Transacao("Deposito", valor));
            return true;
        }
    }

    public void exibirTransacoes() {
        for (Transacao conta : transacoes) {
            System.out.println("*************");
            System.out.println("Extrato das transacoes da conta " + numeroConta + ":");
            System.out.println(
                    "\nTipo ->" + conta.getDescricao() +
                            "\nValor ->" + conta.getValor() +
                            "\nData ->" + conta.getData() + "\n");
        }
    }

    public void notificacao(String desc, double val, Conta conta) {
        System.out.println("O cliente " + conta.cliente.getNomeCliente() + " " + desc + " de R$" + val);
    }

    public void exibirInfoCliente() {
        System.out.println("\nNome ->" + this.cliente.getNomeCliente() + "\nCPF ->" + this.cliente.getCpfCliente()
                + "\nNumero da conta ->" + this.numeroConta
                + "\nNumero da agencia ->" + this.numeroAgencia
                + "\nTipo ->" + getTipoConta() + "\nSaldo ->" + this.saldo + "\nData de nascimento ->"
                + this.getCliente().getDataNascimento());
        if (cliente.getEndereco() != null) {
            System.out.println("Endereco : " + cliente.exibirEndereco());
        }
    }

    public void mostrarSaldo() {
        System.out.println("O saldo atual da conta " + numeroConta + " é R$" + saldo);
    }
}
