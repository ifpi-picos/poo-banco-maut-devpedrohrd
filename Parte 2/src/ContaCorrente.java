class ContaCorrente extends Conta {
    private double chequeEspecial;
    private int qtdTrans;

    public ContaCorrente(String numeroConta, String numeroAgencia, Cliente cliente) {
        super(numeroConta, numeroAgencia, cliente);
        this.chequeEspecial = 1000;
        this.qtdTrans = 0;
    }

    public double getChequeEspecial() {
        return this.chequeEspecial + saldo;
    }

    @Override
    public boolean transferir(Conta destino, double valor) {
        if (valor <= chequeEspecial) {
            super.transferir(destino, valor);
            System.out.println("Transferencia realizada com sucesso !!\n");
            if (qtdTrans > 2) {
                double taxaTrans = (valor * 0.1);
                setSaldo(valor + taxaTrans);
            }
            qtdTrans++;
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= getChequeEspecial()) {
            super.sacar(valor);
            System.out.println("Saque de R$" + valor + " realizado com sucesso !!\n");
            return true;
        }
        return false;
    }

    @Override
    public boolean depositar(double valor) {
        if (valor > 0) {
            super.depositar(valor);
            System.out.println("Deposito de R$" + valor + " realizado com sucesso !!\n");
            return true;
        }
        return false;
    }
}