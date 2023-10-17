class ContaCorrente extends Conta {
    public double chequeEspecial;

    private Conta 
    public ContaCorrente(String numeroAgencia, String numeroConta, Cliente cliente, String tipoConta) {
        super(numeroAgencia, numeroConta, cliente, tipoConta);
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

}
