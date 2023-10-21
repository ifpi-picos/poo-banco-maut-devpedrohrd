class ContaCorrente extends Conta {
    private double chequeEspecial;
    private int qtdTrans;

    public ContaCorrente(String numeroConta, String numeroAgencia, Cliente cliente) {
        super(numeroConta, numeroAgencia, cliente);
        this.chequeEspecial = 1000;
        this.qtdTrans = 0;
    }

    public double getChequeEspecial() {
        return this.chequeEspecial + super.saldo;
    }

    public double getSaldoCorrente() {
        return super.getSaldo();
    }

    @Override
    public boolean transferir(Conta destino, double valor) {
        if (valor <= getChequeEspecial()) {
            if (qtdTrans > 2) {
                double taxaTrans = (valor * 0.1);
                setSaldo(getChequeEspecial() - (valor + taxaTrans));
                System.out.println("Transferencia realizada com sucesso !!\n");
                destino.setSaldo(destino.getSaldo() + valor);
                return true;
            } else {
                setSaldo(getChequeEspecial() - valor);
                destino.setSaldo(destino.getSaldo() + valor);
                System.out.println("Transferencia realizada com sucesso !!\n");
                qtdTrans++;
                return true;
            }
        } else {
            System.err.println("Valor insuficiente para a transferência!");
            return false;
        }

    }
}