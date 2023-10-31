import java.time.LocalDate;

public class App {
        public static void main(String[] args) throws Exception {

                /*
                 * Criação do cliente1 com atributos : Nome,CPF,Data de Nascimento,Endereco Completo
                 * .
                 */
                Cliente Pedro = new Cliente("Pedro Henrque", LocalDate.of(2002, 12, 26),
                                "1234567890", new Endereco("Rua 45", "Pedras", "649000-000",
                                                "Bom Jesus", "1291", "PI"));

                Cliente Matheus = new Cliente("Matheus", LocalDate.of(2003, 06, 21), "0987654321",
                                null);

                // o tipo da variável deve ser o mais genérico
                Conta cc = new ContaCorrente("123", "321", Pedro, new NotificacaoEmail());
                Conta cc2 = new ContaCorrente("123", "321", Pedro, new NotificacaoEmail());
                Conta cp = new ContaPoupanca("321", "321", Matheus, new NotificacaoSMS());

                cc.depositar(100);
                System.out.println(cc.getSaldo());
                cc.sacar(50);
                System.out.println(cc.getSaldo());
                cc.transferir(cc2, 10);
                cc.transferir(cc2, 10);
                cc.transferir(cc2, 10);
                cc.transferir(cc2, 10);
                cc.transferir(cc2, 10);
                cc.transferir(cc2, 10);
                System.out.println(cc.getSaldo());
                cc.exibirTransacoes();

                cp.depositar(100);
                cp.sacar(10);

                System.out.println(cp.getSaldo());
                cp.exibirTransacoes();

                // tudo certo, parabéns!
        }
}
