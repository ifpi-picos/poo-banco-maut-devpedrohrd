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

                System.out.println("----------Dados do Cliente ----------");
                System.out.println("Nome: " + Pedro.getNome());
                System.out.println("CPF: " + Pedro.getCpf());
                System.out.println("Data de nascimento: " + Pedro.getDataNascimento());
                System.out.println("Sua rua é: " + Pedro.getEndereco().getRua());
                System.out.println("Seu número é: " + Pedro.getEndereco().getNumero());
                System.out.println(
                                "Seu bairro e cidade são: " + Pedro.getEndereco().getBairro() + ", "
                                                + Pedro.getEndereco().getCidade());
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
                System.out.println("Data de nascimento(cliente1): " + conta1.getCliente().getDataNascimento());
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

                // Primeira transferência
                conta1.transferir(conta2, 250);
                System.out.println("\nTransferiu para a conta poupança do cliente2 R$250");
                System.out.println("Saldo Atual da conta corrente do cliente1: " + conta1.getSaldo());

                // A conta corrente permite fazer até 2 transferências sem cobrar taxa (taxa de
                // 10%);
                // Segunda transferencia
                conta1.transferir(conta2, 50);
                System.out.println("\nTransferiu para a conta poupança do cliente2 R$50");
                System.out.println("O saldo atual: " + conta1.getSaldo());
                // Terceira transferencia(A partir da terceira há cobrança de taxa !!)
                conta1.transferir(conta2, 50);
                System.out.println("\nTransferiu para a conta poupança do cliente2 R$50");
                System.out.println("O saldo atual: R$" + conta1.getSaldo()
                                + "(Houve uma cobrança de taxa(10% * 50 = 5) que foi descontado diretamente no saldo)\n");

                // Exibindo o extrato de transações da conta1
                conta1.exibirTransacoes();

                System.out.println(
                                "\nTeste das operações da Conta Poupança(Saque,deposito,transferencia e extrato de transações)\n");
                /*
                 * Teste das operações da Conta Poupança(Saque,deposito,transferencia e extrato
                 * de transações)
                 */
                ContaPoupanca conta3 = new ContaPoupanca("890", "980", Matheus, new NotificacaoSMS());
                // OPeração deposito
                conta3.depositar(1000);
                System.out.println("\nDepositou no cliente2 R$1000 na conta poupança");
                System.out.println("Saldo Atual: R$" + conta3.getSaldo()
                                + "(Na conta poupança, cada déposito tem um rendimento de 10% !! )\n");
                // Operação saque
                conta3.sacar(100);
                System.out.println("\nSacou R$100 da conta poupança do cliente2");
                System.out.println("Saldo Atual: R$" + conta3.getSaldo()
                                + "(A conta poupança cobra uma taxa de 5%(100*0.05 = R$5) do valor da transacão para cada saque realizado)\n");

                // Operação transferência
                conta3.transferir(conta1, 100);
                System.out.println("\nTransferiu para a conta corrente do cliente1 R$100");
                System.out.println("Saldo Atual da conta poupança do cliente2: R$" + conta3.getSaldo()
                                + "(A conta poupança cobra uma taxa de 10% para cada transferência)\n");

                // Extrato de transações da conta3

                conta3.exibirTransacoes();
        }
}
