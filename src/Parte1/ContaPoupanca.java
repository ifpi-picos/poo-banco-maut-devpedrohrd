public class ContaPoupanca {
    private Conta conta;

    public ContaPoupanca(Conta conta) {
        this.conta = conta;
    }

    public boolean sacar(double valor) {
        if (conta.getSaldo() >= valor) {
            conta.sacar(valor);
            conta.notificacao("realizou um saque ", valor, conta);
            return true;
        }
        System.out.println("Nao foi possivel realizar o saque !!");
        return false;
    }

    public boolean depositar(double valor) {
        if (conta.depositar(valor + (valor * 0.10))) {
            conta.notificacao("realizou um deposito ", valor, conta);
            return true;
        }
        return false;
    }

    public boolean transferir(Conta origem, Conta destino, double valor) {
        if (origem != null && origem.getTipoConta().equalsIgnoreCase("p")) {
            double valorTaxado = valor + (valor * 0.05);
            if (origem.sacar(valorTaxado)) {
                destino.depositar(valor);
                origem.notificacao("realizou uma transferencia", valor, origem);
                destino.notificacao("recebeu uma de transferencia", valor, destino);
                System.out.println(
                        "Transferencia de R$" + valor + " do cliente " + origem.getCliente().getNomeCliente()
                                + " para o cliente " + destino.getCliente().getNomeCliente()
                                + " realizada com sucesso !!");
                return true;
            } else {
                System.out.println("Falha ao realizar a transferencia !!");
            }
        } else {
            System.out.println("Conta origem invalida !!");
        }
        return false;
    }
}
