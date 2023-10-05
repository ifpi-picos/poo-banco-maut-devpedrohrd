import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner prompt = new Scanner(System.in);
        Sistema sistema = new Sistema();
        int opcao;

        do {
            sistema.menu();
            opcao = prompt.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("***** CADASTRO CLIENTE *****");
                    sistema.addCliente();
                    break;
                default:
                    throw new IllegalArgumentException("Opção inválida!");
            }
        } while (opcao != 7);
    }
}
