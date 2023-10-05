import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BancoDados {
    private List<Conta> contas;
    private List<Cliente> clientes;
    Scanner prompt = new Scanner(System.in);

    public BancoDados() {
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void addListaContas(Conta conta) {
        System.out.println("Adicionando conta");
        contas.add(conta);
    }

    public Cliente addListaClientes(Cliente cliente) {
        System.out.println("Clinte adicionado ao Banco de Dados !!");
        clientes.add(cliente);
        return cliente;
    }

    public Conta procuraNumeroConta(String numeroConta) {
        for (Conta numConta : contas) {
            if (numConta.getNumeroConta().equals(numeroConta)) {
                return numConta;
            }
        }
        return null;
    }

    public void menu() {
        System.out.println("\n****** MENU BANCO MAUT *****");
        System.out.println("1)Cadastrar cliente");
        System.out.println("2)Cadastrar conta");
        System.out.println("3)Depositar");
        System.out.println("4)Sacar");
        System.out.println("5)Transferir");
        System.out.println("6)Consultar saldo");
        System.out.println("7)Extrato das transacoes do cliente");
        System.out.println("8)Sair");
    }

    /**
     * @return
     */
    public Cliente addCliente() {

        String nome, cpf;
        LocalDate dataNascimento;
        int dia, mes, ano;
        String respostaEndereco;

        System.out.println("Digite o nome do cliente:");
        nome = prompt.nextLine();
        System.out.println("Digite o CPF do cliente: ");
        cpf = prompt.nextLine();

        System.out.println("Digite o dia do nascimento:");
        dia = prompt.nextInt();
        System.out.println("Digite o mes do nascimento:");
        mes = prompt.nextInt();
        System.out.println("Digite o ano do nascimento:");
        ano = prompt.nextInt();
        prompt.nextLine();

        if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && ano >= 1900) {
            dataNascimento = LocalDate.of(ano, mes, dia);
            System.out.println("Deseja adicionar algum endereco?");
            respostaEndereco = prompt.nextLine();
            if (respostaEndereco.equalsIgnoreCase("sim") || respostaEndereco.equalsIgnoreCase("s")) {
                System.out.println("Digite o nome da rua:");
                String rua = prompt.nextLine();
                System.out.println("Digite o nome do bairro:");
                String bairro = prompt.nextLine();
                System.out.println("Digite o CEP:");
                String cep = prompt.nextLine();
                System.out.println("Digite o numero:");
                String numero = prompt.nextLine();
                System.out.println("Digite a cidade:");
                String cidade = prompt.nextLine();

                Endereco endereco = new Endereco(rua, bairro, cep, cidade, numero, cidade);
                Cliente cliente = new Cliente(nome, cpf, dataNascimento, endereco);
                addListaClientes(cliente);
                return cliente;
            } else if (respostaEndereco.equalsIgnoreCase("nao") || respostaEndereco.equalsIgnoreCase("n")) {
                Cliente cliente = new Cliente(nome, cpf, dataNascimento, null);
                System.out.println("O cliente optou por nao informar o endereco !!");
                addListaClientes(cliente);
                return cliente;
            } else {
                System.out.println("Resposta inválida. Digite 'sim' ou 'nao' para adicionar um endereço.");
            }
        } else {
            System.out.println("Data de nascimento inválida. Verifique os valores de dia, mês e ano.");
        }
        return null;
    }

    /**
     * @return
     */
    public Conta addConta() {
        System.out.println("Digite o numero da conta:");
        String numConta = prompt.nextLine();
        System.out.println("Digite o numero da agencia:");
        String numAgencia = prompt.nextLine();
        System.out.println("Digite o nome do cliente:");
        String nome = prompt.nextLine();
        System.out.println("Digite o cpf do cliente:");
        String cpf = prompt.nextLine();

        Cliente cliente = new Cliente(nome, cpf, null, null);

        Conta conta = new Conta(numAgencia, numConta, cliente, null, null);
        contas.add(conta);
        System.out.println("Conta cadastrada com sucesso !!");
        return conta;

    }

}
