import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int opcao;
        int opt;
        Scanner prompt = new Scanner(System.in);
        Cliente cliente = new Cliente("Pedro", "1234567891", "26/12/2002", "Rua Mato Grosso");
        Conta conta = new Conta("2780", "0008595", 0, cliente);

        do {
            System.out.println("****** MENU BANCO MAUT ******");
            System.out.println("1) INFORMACOES DO CLIENTE");
            System.out.println("2) OPERACOES");
            System.out.println("0) SAIR");
            System.out.print("Digite uma opcao ->");
            opcao = prompt.nextInt();
            prompt.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("***** INFORMACOES DOS CLIENTES *****");
                    System.out.println("Nome -> " + cliente.getNomeCliente() +
                            "\nCPF ->" + cliente.getCpfCliente() +
                            "\nData de Nascimento -> " + cliente.getDataNascimento() +
                            "\nEndereco ->" + cliente.getEndereco());
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
                            Cliente cliente2 = new Cliente("Paulo", "9876543210", "24/12/2003", "Rua Paisandu");
                            Conta conta2 = new Conta("2780", "12345", 0, cliente2);
                            System.out.println("Digite o valor da transferencia:");
                            double transferencia = prompt.nextDouble();
                            conta.transferir(conta2.getNumeroConta(), transferencia);
                            System.out
                                    .println("O cliente " + cliente.getNomeCliente() + " transferiu R$" + transferencia
                                            + "para a o cliente " + cliente2.getNomeCliente());
                            break;
                        case 4:
                            System.out.println("***** INFORMACOES DA CONTA *****");
                            System.out.println("Agencia -> " + conta.getNumeroAgencia() +
                                    "\nConta ->" + conta.getNumeroConta() +
                                    "\nSaldo -> " + conta.getSaldo() +
                                    "\nCliente ->" + conta.getCliente().getNomeCliente());
                            break;
                        default:
                            throw new RuntimeException("Opção invalida!");
                    }
                    break;
                case 0:
                    System.out.println("Obrigado!");
                    break;
                default:
                    throw new RuntimeException("Opção invalida!");
            }
        } while (opcao != 0);
    }
}
