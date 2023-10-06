import java.util.Scanner;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner prompt = new Scanner(System.in);
        Sistema sistema = new Sistema();
        int opcao;
        Conta conta;

        do {
            sistema.menu();
            opcao = prompt.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("***** CADASTRO CONTA-CLIENTE *****");
                    conta = sistema.addConta();
                    if (conta != null) {
                        sistema.addListaContas(conta);
                    }
                    break;
                case 2:
                    System.out.println("Digite o numero da conta que deseja fazer deposito:");
                    String numContaDepos = prompt.next();
                    prompt.nextLine();

                    conta = sistema.procuraNumeroConta(numContaDepos);

                    if (conta != null) {
                        System.out.print("Digite o valor a ser depositado : ");
                        double deposito = prompt.nextDouble();
                        prompt.nextLine();

                        if (conta.depositar(deposito)) {
                            conta.notificacao("Deposito", deposito);
                            conta.mostrarSaldo();
                        } else {
                            System.out.println("Falha ao realizar deposito !!");
                        }
                    } else {
                        System.out.println("Numero da conta invalido !!");
                    }
                    break;
                case 3:
                    System.out.println("Digite o numero da conta que deseja realizar o saque :");
                    String numContaSaque = prompt.next();
                    prompt.nextLine();

                    conta = sistema.procuraNumeroConta(numContaSaque);
                    System.out.println(conta);
                    System.out.println(numContaSaque);
                    if (conta != null) {
                        System.out.print("Digite o valor a ser sacado : ");
                        double saque = prompt.nextDouble();
                        prompt.nextLine();
                        if (conta.sacar(saque)) {
                            conta.notificacao("saque", saque);
                            conta.mostrarSaldo();
                        } else {
                            System.out.println("Falha ao realizar o saque !!");
                        }
                    } else {
                        System.out.println("Numero da conta invalido !!");
                    }
                    break;
                case 4:
                    System.out.println("Digite o numero da conta Origem :");
                    String numContaOrigem = prompt.next();
                    prompt.nextLine();

                    System.out.println("Digite o numero da conta Destino:");
                    String numContaDestino = prompt.next();
                    prompt.nextLine();

                    System.out.println("Digite o valor da transaferencia:");
                    double transferencia = prompt.nextDouble();
                    prompt.nextLine();

                    sistema.realizarTransferencia(numContaOrigem, numContaDestino, transferencia);
                    break;
                case 5:
                    System.out.println("Digite o numero da conta que deseja vizualizar o saldo:");
                    String numConta = prompt.next();
                    prompt.nextLine();

                    conta = sistema.procuraNumeroConta(numConta);

                    if (conta != null) {
                        conta.mostrarSaldo();
                    } else {
                        System.out.println("Numero da conta invalido !!");
                    }
                    break;
                case 6:
                    System.out.println("Digite o numero da conta para consultar o saldo:");
                    String numCon = prompt.next();
                    prompt.nextLine();
                    conta = sistema.procuraNumeroConta(numCon);

                    if (conta != null) {
                        conta.exibirInfoCliente();
                        conta.exibirTransacoes();
                    } else {
                        System.out.println("Numero da Conta nao encontrada !!");
                    }
                    break;
                case 0:
                    System.out.println("Saido do Sistema !!");
                    break;
                default:
                    throw new IllegalArgumentException("Opção inválida!");
            }
        } while (opcao != 0);
    }
}