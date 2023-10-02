import java.util.Scanner;

public class Conta {
    private String numeroAgencia;
    private String numeroConta;
    private double saldo;
    private final Cliente cliente;

    Scanner prompt = new Scanner(System.in);

    public Conta(String numeroAgencia, String numeroConta, double saldo, Cliente cliente) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.cliente = cliente;
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
        if (valor <= 0) {
            System.out.println("Digite um valor inteiro positivo !");
        } else {
            saldo += valor;
            System.out.println("Saque realizado com sucesso!!");
            System.out.println("O cliente " + cliente.getNomeCliente() + " sacou R$" + valor + "!");
        }
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Digite um valor inteiro positivo !!");
        } else {
            saldo += valor;
            System.out.println("Deposito realizado com sucesso!!");
            System.out.println("O cliente " + cliente.getNomeCliente() + " depositou R$" + valor + "!");
        }
    }

    public void transferir(String numeroConta, double valor) {
        if (valor > 0 && valor < saldo) {
            if (getNumeroConta().equals(numeroConta)) {
                saldo -= valor;
                System.out.println("Transferencia realizada com sucesso!!");
                System.out.println("O cliente " + cliente.getNomeCliente() + " transferiu R$" + valor
                        + "para a o cliente " + numeroConta);
            } else {
                System.out.println("Nao foi possivel realizar a transferencia !!");
            }
        }
    }

}
