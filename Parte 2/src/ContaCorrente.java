class ContaCorrente extends Conta {
    private double chequeEspecial;
    private int qtdTrans;

    public ContaCorrente(String numeroConta, String numeroAgencia, Cliente cliente, Notificacao notificacao) {
        super(numeroConta, numeroAgencia, cliente, notificacao);
        this.chequeEspecial = 1000;
        this.qtdTrans = 0;
    }

    public double getChequeEspecial() {
        return super.saldo + this.chequeEspecial;
    }

    public double getSaldoCorrente() {
        return super.getSaldo();
    }

    @Override
    public boolean transferir(Conta destino, double valor) {
        if (valor <= getChequeEspecial()) {
            if (qtdTrans > 2) {
                double taxaTrans = (valor * 0.1);
                super.saldo -= (valor + taxaTrans);
                System.out.println("Transferencia realizada com sucesso !!\n");
                destino.saldo -= valor;
                getNotificacao().enviarNotificacao("Transferencia", valor);
                getTransacoes().add(new Transacao("Transferencia", -valor));
                destino.getTransacoes().add(new Transacao("Recibo transferencia", valor));
                return true;
            } else {
                super.saldo -= valor;
                destino.saldo += valor;
                System.out.println("Transferencia realizada com sucesso !!\n");
                getNotificacao().enviarNotificacao("Transferencia", valor);
                qtdTrans++;
                getTransacoes().add(new Transacao("Transferencia", -valor));
                destino.getTransacoes().add(new Transacao("Recibo transferencia", valor));
                return true;
            }
        } else {
            System.err.println("Valor insuficiente para a transferência!");
            return false;
        }

    }

    @Override
    public boolean sacar(double valor) {
        if (getChequeEspecial() > valor) {
            super.saldo -= valor;
            System.out.println("Saque realizado com sucesso!!\n");
            getNotificacao().enviarNotificacao("Saque", valor);
            getTransacoes().add(new Transacao("Saque", valor));
            return true;
        }
        if (valor > getChequeEspecial()) {
            System.err.println("Valor insuficiente para o saque!");
            return false;
        }
        System.out.println("Nao foi possivel realizar o saque !!");
        return false;
    }
}