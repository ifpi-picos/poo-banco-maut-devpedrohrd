public class ContaCorrente {
    private Conta conta;
    private int qtdTrans;
    private double chequeEspecial;
    private double saldo;

    public ContaCorrente(Conta conta, double limiteChequeEspecial) {
        this.conta = conta;
        this.qtdTrans = 0;
        this.chequeEspecial = limiteChequeEspecial;
        this.saldo = 0.0;
    }

    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        } else if (saldo + chequeEspecial >= valor) {
            double valorExedente = valor - saldo;
            saldo = 0;
            chequeEspecial -= valorExedente;
            return true;
        }
        return false;
    }

    public boolean depositarCorrente(double valor) {
        if (conta.depositar(valor)) {
            return true;
        }
        return false;
    }

    public boolean transferirCorrente(Conta origem, Conta destino, double valor) {
        if (origem != null) {
            double valorTaxado = valor * 0.10;
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
                origem.notificacao("realizou uma transferencia", valor, origem);
                destino.notificacao("recebeu uma de transferencia", valor, destino);
                System.out.println(
                        "Transferencia de R$" + valor + " do cliente " + origem.getCliente().getNomeCliente()
                                + " para o cliente " + destino.getCliente().getNomeCliente()
                                + " realizada com sucesso !!");
                return true;
            }
        }
        return false;
    }
}
