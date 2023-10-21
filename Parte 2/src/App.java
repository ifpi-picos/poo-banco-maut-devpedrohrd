import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {

        /*
         * Criação do cliente1 com atributos : Nome,CPF,Data de Nascimento,Endereco
         * Completo .
         */
        Cliente Pedro = new Cliente("Pedro Henrque", LocalDate.of(2002, 12, 26), "1234567890",
                new Endereco("Rua 45", "Pedras", "649000-000", "Bom Jesus", "1291",
                        "PI"));

        System.out.println("----------Dados de Cliente ----------");
        System.out.println("Nome: " + Pedro.getNome());
        System.out.println("CPF: " + Pedro.getCpf());
        System.out.println("Data de nascimento: " + Pedro.getDataNascimento());
        System.out.println("Sua rua é: " + Pedro.getEndereco().getRua());
        System.out.println("Seu número é: " + Pedro.getEndereco().getNumero());
        System.out.println(
                "Seu bairro e cidade são: " + Pedro.getEndereco().getBairro() + ", " + Pedro.getEndereco().getCidade());
        System.out.println("Seu uf é: " + Pedro.getEndereco().getEstado());
        System.out.println("----------Fim de dados----------");
        /*
         * Criação da conta (Corrente ou Poupança) com atributos : Numero da conta
         * ,numero da agencia ,Cliente .
         */
        ContaCorrente conta1 = new ContaCorrente("123", "321", Pedro, new NotificacaoEmail());

        System.out.println("----------Informações da conta do cliente1----------");
        System.out.println("Nome Cliente: " + conta1.getCliente().getNome());
        System.out.println("Numero da conta: " + conta1.getNumeroConta());
        System.out.println("Numero da agencia: " + conta1.getNumeroAgencia());
        System.out.println("Data de nascimento(cliente1): " + Pedro.getDataNascimento());
        System.out.println("----------Fim de informacoes----------");

        // Cliente 2
        Cliente Matheus = new Cliente("Matheus", LocalDate.of(2003, 06, 21), "0987654321", null);
        ContaPoupanca conta2 = new ContaPoupanca("321", "321", Matheus, new NotificacaoSMS());
        /*
         * Teste das operações da Conta Corrente (Saque,deposito,transferencia e extrato
         * de transações)
         */

        System.out.println(
                "\nTeste das operações da Conta Corrente (Saque,deposito,transferencia e extrato de transações)");
        conta1.depositar(1000);
        System.out.println("\nO cliente depositou R$1000 na conta corrente do cliente1");
        System.out.println("Saldo Atual: " + conta1.getSaldo());

        conta1.sacar(500);
        System.out.println("\nO cliente sacou R$500 da conta corrente do cliente1");
        System.out.println("Saldo Atual: " + conta1.getSaldo());

        conta1.transferir(conta2, 250);
        System.out.println("\nTransferiu para a conta poupança do cliente2 R$250");
        System.out.println("Saldo Atual da conta corrente do cliente1: " + conta1.getSaldo());

        // A conta corrente permite fazer até 2 transferências sem cobrar taxa (taxa de
        // 10%);

        conta1.transferir(conta2, 50);
        System.out.println("\nTransferiu para a conta poupança do cliente2 R$50");
        System.out.println("O saldo atual: " + conta1.getSaldo());
        conta1.transferir(conta2, 50);
        System.out.println("\nTransferiu para a conta poupança do cliente2 R$50");
        System.out.println("O saldo atual: " + conta1.getSaldo()
                + "(Houve uma cobrança de taxa(10% * 50 = 5) que foi descontado diretamente no saldo)");
    }
}
