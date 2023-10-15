public class ContaCorrente {
    private Conta conta;
    private int qtdTrans;
    private double chequeEspecial;

    public ContaCorrente(Conta conta) {
        this.conta = conta;
        this.qtdTrans = 0;
        this.chequeEspecial = 1000;
    }

    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Digite um valor positivo !");
            return false;
        }

        if (conta.getSaldo() >= valor) {
            if (conta.sacar(valor)) {
                conta.notificacao("realizou um saque de", valor, conta);
                return true;
            } else {
                System.out.println("Falha ao realizar saque !!");
            }
        } else if (conta.getSaldo() + chequeEspecial >= valor) {
            double valorExcedente = valor - conta.getSaldo();
            chequeEspecial -= valorExcedente;
            return true;
        } else {
            System.out.println("Saldo insuficiente !!");
        }
        return false;
    }

    public boolean depositarCorrente(double valor) {
        if (conta.depositar(valor)) {
            conta.notificacao("realizou um deposito de ", valor, conta);
            return true;
        }
        System.out.println("Nao foi possivel realizar o deposito !!");
        return false;
    }

    public boolean transferirCorrente(Conta origem, Conta destino, double valor) {
        if (origem != null && origem.getTipoConta().equalsIgnoreCase("c")) {
            double valorTaxado = valor + (valor * 0.10);
            if (qtdTrans < 2) {
                if (origem.sacar(valor)) {
                    destino.depositar(valor);
                    qtdTrans++;
                    origem.notificacao("realizou uma transferencia", valor, origem);
                    destino.notificacao("recebeu uma de transferencia", valor, destino);
                    System.out.println(
                            "Transferencia de R$" + valor + " do cliente " + origem.getCliente().getNomeCliente()
                                    + " para o cliente " + destino.getCliente().getNomeCliente()
                                    + " realizada com sucesso !!");
                    return true;
                } else {
                    System.out.println("Falha ao realizar transferencia !!");
                }

            } else {
                origem.sacar(valorTaxado);
                destino.depositar(valor);
                origem.notificacao("realizou uma transferencia", valorTaxado, origem);
                destino.notificacao("recebeu uma de transferencia", valor, destino);
                System.out.println(
                        "Transferencia de R$" + valor + " do cliente " + origem.getCliente().getNomeCliente()
                                + " para o cliente " + destino.getCliente().getNomeCliente()
                                + " realizada com sucesso !!");
                return true;
            }
        } else {
            System.out.println("Conta de origem invalida para a tranferencia !!");
        }
        return false;
    }
}
