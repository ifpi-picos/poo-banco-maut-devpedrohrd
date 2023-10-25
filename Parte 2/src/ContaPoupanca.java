public class ContaPoupanca extends Conta {

    public ContaPoupanca(String numeroConta, String numeroAgencia, Cliente cliente, Notificacao notificacao) {
        super(numeroConta, numeroAgencia, cliente, notificacao);
    }

    @Override
    public boolean depositar(double valor) {
        if (valor > 0) {
            double rendimentoDeposito = valor + (valor * 0.1);
            super.saldo += rendimentoDeposito;
            getNotificacao().enviarNotificacao("Deposito", valor);
            getTransacoes().add(new Transacao("Deposito", valor));
            return true;
        }
        System.out.println("Nao foi possivel realizar o deposito !!");
        return false;
    }

    @Override
    public boolean sacar(double valor) {
        double valorTaxado = valor + (valor * 0.05);
        if (valorTaxado > 0 && valorTaxado <= super.saldo) {
            super.saldo -= valorTaxado;
            getNotificacao().enviarNotificacao("Saque", valor);
            getTransacoes().add(new Transacao("Saque", valor));
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor invalido para saque !!");
            System.out.println("Nao foi possivel realizar o saque !!");
            return false;
        }
    }

    @Override
    public boolean transferir(Conta contaDestino, double valor) {
        double valorTaxado = valor + (valor * 0.1);
        if (valorTaxado < super.saldo) {
            super.saldo -= valorTaxado;
            contaDestino.saldo += valor;
            getNotificacao().enviarNotificacao("Transferencia", valor);
            getTransacoes().add(new Transacao("Transferencia", valorTaxado));
            contaDestino.getTransacoes().add(new Transacao("Recibo transferencia ", valor));
            return true;
        } else if (valor < saldo) {
            System.out.println("Saldo insuficiente para realizar a transferencia !!");
        }
        System.out.println("Nao foi possivel realizar a transferencia !! ");
        return false;
    }
}
