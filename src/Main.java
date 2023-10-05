import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner prompt = new Scanner(System.in);
        BancoDados sistema = new BancoDados();
        int opcao;

        do {
            sistema.menu();
            opcao = prompt.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("***** CADASTRO CLIENTE *****");
                    sistema.addCliente();
                    break;
                case 2:
                    System.out.println("***** CADATRO CONTA-CLINTE *****");
                    sistema.addConta();
                    break;
                default:
                    throw new IllegalArgumentException("Opção inválida!");
            }
        } while (opcao != 7);
    }
}
