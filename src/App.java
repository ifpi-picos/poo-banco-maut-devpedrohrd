import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int opcao;
        int opt = 0;
        Scanner prompt = new Scanner(System.in);
        Cliente cliente = new Cliente(null, null, null, null);
        Sistema sistema = new Sistema(null, cliente);
        Conta conta = new Conta(null, null, opt, cliente);

        do {
            System.out.println("****** MENU BANCO MAUT ******");
            System.out.println("1) CADASTRAR CLIENTE");
            System.out.println("2) OPERACOES");
            System.out.println("0) SAIR");
            System.out.print("Digite uma opcao ->");
            opcao = prompt.nextInt();
            prompt.nextLine();

            switch (opcao) {
                case 1:
                    Cliente novoCliente = cliente.cadastraCliente();
                    sistema.addClientesLista(novoCliente);
                    break;
                case 2:

                    System.out.println("***** OPERACOES *****");
                    System.out.println("1) Saque");
                    System.out.println("2) Desposito");
                    System.out.println("3) Transferencia");
                    System.out.println("4) Mostrar informacoes da conta");
                    System.out.println("5) Sair");
                    opt = prompt.nextInt();
                    prompt.nextLine();

                    switch (opt) {
                        case 1:
                            System.out.println("Digite o valor que deseja sacar:");
                            double saque = prompt.nextDouble();
                            conta.sacar(saque);
                            break;
                        case 2:
                            System.out.println("Digite o valor que deseja depositar:");
                            double deposito = prompt.nextDouble();
                            conta.depositar(deposito);
                            break;
                        case 3:
                            System.out.println("Digite o numero da conta destino:");
                            String numeroConta = prompt.nextLine();
                            System.out.println("Digite o valor da transferencia:");
                            double transferencia = prompt.nextDouble();
                            conta.transferir(numeroConta, transferencia);
                            break;
                        case 4:
                            sistema.mortrarInformacoes(conta, cliente);
                    }

            }
        } while (opcao != 0);
    }
}
