class ContaCorrente extends Conta {
    private double chequeEspecial;
    private int qtdTrans;

    public ContaCorrente(String numeroConta, String numeroAgencia, Cliente cliente, Notificacao notificacao) {
        super(numeroConta, numeroAgencia, cliente, notificacao);
        this.chequeEspecial = 1000;
        this.qtdTrans = 1;
    }

    public double getChequeEspecial() {
        return super.saldo + this.chequeEspecial;
    }

    public double getSaldoCorrente() {
        return super.getSaldo();
    }

    @Override
    public boolean transferir(Conta destino, double valor) {
        if (valor > 0 && valor <= getChequeEspecial()) {
            if (qtdTrans > 2) {
                double taxaTrans = (valor * 0.1);
                super.saldo -= (valor + taxaTrans);
                destino.saldo += valor;
                getNotificacao().enviarNotificacao("Transferencia", valor);
                System.out.println("Transferencia realizada com sucesso !!\n");
                getTransacoes().add(new Transacao("Transferencia", valor));
                destino.getTransacoes().add(new Transacao("Recibo transferencia", valor));
                ++qtdTrans;
                return true;
            } else {
                super.saldo -= valor;
                destino.saldo += valor;
                getNotificacao().enviarNotificacao("Transferencia", valor);
                qtdTrans++;
                System.out.println("Transferencia realizada com sucesso !!\n");
                getTransacoes().add(new Transacao("Transferencia", valor));
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
            getNotificacao().enviarNotificacao("Saque", valor);
            getTransacoes().add(new Transacao("Saque", valor));
            System.out.println("Saque realizado com sucesso !!");
            return true;
        }
        if (valor > getChequeEspecial()) {
            System.err.println(
                    "Limite do cheque especial insuficiente para realizar o saque! Nao foi possivel realizar o saque !!");
            return false;
        }
        System.out.println("Nao foi possivel realizar o saque !!");
        return false;
    }
}