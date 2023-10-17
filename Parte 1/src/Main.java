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
                        System.out.println("***** CLIENTE CRIADO COM SUCESSO *****");
                    }
                    break;
                case 2:
                    System.out.println("Digite o numero da conta que deseja realizar um deposito:");
                    String numContaDepos = prompt.next();
                    prompt.nextLine();

                    conta = sistema.procuraNumeroConta(numContaDepos);

                    if (conta != null) {
                        System.out.print("Conta encontrada !! \nDigite o valor a ser depositado : ");
                        double deposito = prompt.nextDouble();
                        prompt.nextLine();

                        if (conta.getTipoConta().equals("c")) {
                            conta.getCorrente().depositarCorrente(deposito);
                            conta.mostrarSaldo();
                        } else if (conta.getTipoConta().equals("p")) {
                            conta.getPoupanca().depositar(deposito);
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

                    if (conta != null) {
                        System.out.print("Conta encontrada !! \nDigite o valor a ser sacado : ");
                        double saque = prompt.nextDouble();
                        prompt.nextLine();
                        if (conta.getTipoConta().equals("c")) {
                            conta.getCorrente().sacar(saque);
                            conta.mostrarSaldo();
                        } else if (conta.getTipoConta().equals("p")) {
                            conta.getPoupanca().sacar(saque);
                            conta.mostrarSaldo();
                        } else {
                            System.out.println("Numero da conta invalido !!");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Digite o numero da conta Origem :");
                    String numContaOrigem = prompt.next();
                    prompt.nextLine();

                    System.out.println("Digite o numero da conta Destino:");
                    String numContaDestino = prompt.next();
                    prompt.nextLine();

                    System.out.println("Digite o valor da transferencia:");
                    double transferencia = prompt.nextDouble();
                    prompt.nextLine();

                    sistema.realizarTransferencia(numContaOrigem, numContaDestino, transferencia);
                    break;
                case 5:
                    System.out.println("Digite o numero da conta para vizualizar as informacoes do cliente :");
                    String numConta = prompt.next();
                    prompt.nextLine();

                    conta = sistema.procuraNumeroConta(numConta);

                    if (conta != null) {
                        conta.exibirInfoCliente();
                    } else {
                        System.out.println("Numero da conta invalido !!");
                    }
                    break;
                case 6:
                    System.out.println("Digite o numero da conta para consultar o extrato de transacoes:");
                    String numCon = prompt.next();
                    prompt.nextLine();
                    conta = sistema.procuraNumeroConta(numCon);

                    if (conta != null) {
                        conta.exibirTransacoes();
                    } else {
                        System.out.println("Numero da Conta nao encontrada !!");
                    }
                    break;
                case 0:
                    System.out.println("Saindo do Sistema !!");
                    break;
                default:
                    throw new IllegalArgumentException("Opção inválida!");
            }
        } while (opcao != 0);
    }
}