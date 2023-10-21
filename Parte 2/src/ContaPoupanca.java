public class ContaPoupanca extends Conta {

    public ContaPoupanca(String numeroConta, String numeroAgencia, Cliente cliente) {
        super(numeroConta, numeroAgencia, cliente);
    }

    @Override
    public boolean depositar(double valor) {
        if (valor < 0) {
            double rendimentoDeposito = valor + (valor * 0.1);
            this.saldo += rendimentoDeposito;
            return true;
        }

        return false;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor < super.saldo) {
            saldo -= valor;
            return true;
        } else if (valor > super.saldo) {
            System.out.println("Saldo insuficiente");
            return false;
        }
        System.out.println("Nao foi possivel realizar o saque !!");
        return false;
    }
}
