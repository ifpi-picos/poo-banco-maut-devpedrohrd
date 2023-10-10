import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private List<Conta> contas;
    Scanner prompt = new Scanner(System.in);

    public Sistema() {
        this.contas = new ArrayList<>();
    }

    public void addListaContas(Conta conta) {
        contas.add(conta);
        System.out.println("Conta adicionada ao Banco de Dados !!");
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
        System.out.println("2)Depositar");
        System.out.println("3)Sacar");
        System.out.println("4)Transferir");
        System.out.println("5)Consultar informacoes da conta");
        System.out.println("6)Extrato de transacoes");
        System.out.println("7)Alterar informacoes do Cliente");
        System.out.println("0)Sair");
    }

    /**
     * @return
     */
    public Conta addConta() {

        String nome, cpf;
        LocalDate dataNascimento;
        int dia, mes, ano;
        String respostaEndereco;

        Cliente cliente;
        Conta conta;

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
                System.out.println("Digite o estado:");
                String estado = prompt.nextLine();

                Endereco endereco = new Endereco(rua, bairro, cep, cidade, numero, estado);
                cliente = new Cliente(nome, cpf, dataNascimento, endereco);

                System.out.println("***** CADASTRO CONTA ***** ");
                System.out.println("Digite o numero da conta:");
                String numConta = prompt.nextLine();
                System.out.println("Digite o numero da agencia:");
                String numAgencia = prompt.nextLine();

                conta = new Conta(numAgencia, numConta, cliente);
                cliente.setConta(conta);
                return conta;
            } else if (respostaEndereco.equalsIgnoreCase("nao") || respostaEndereco.equalsIgnoreCase("n")) {
                cliente = new Cliente(nome, cpf, dataNascimento, null);
                System.out.println("***** CADASTRO CONTA ***** ");
                System.out.println("Digite o numero da conta:");
                String numConta = prompt.nextLine();
                System.out.println("Digite o numero da agencia:");
                String numAgencia = prompt.nextLine();
                conta = new Conta(numAgencia, numConta, cliente);

                cliente.setConta(conta);
                System.out.println("O cliente optou por nao informar o endereco !!");
                return conta;
            } else {
                System.out.println("Resposta inválida. Digite 'sim' ou 'nao' para adicionar um endereço.");
            }
        } else {
            System.out.println("Data de nascimento invalida. Verifique os valores de dia, mês e ano.");
        }
        return null;
    }

    public void realizarTransferencia(String numContaOrigem, String numContaDestino, double valor) {
        Conta contaOrigem = this.procuraNumeroConta(numContaOrigem);
        Conta contaDestino = this.procuraNumeroConta(numContaDestino);
        if (contaDestino != null && contaOrigem != null) {
            if (contaOrigem.sacar(valor)) {
                contaDestino.depositar(valor);
                contaOrigem.notificacao("realizou uma transferencia", valor, contaOrigem);
                contaDestino.notificacao("recebeu uma de transferencia", valor, contaDestino);
                System.out.println(
                        "Transferencia de R$" + valor + " do cliente " + contaOrigem.getCliente().getNomeCliente()
                                + " para o cliente " + contaDestino.getCliente().getNomeCliente()
                                + " realizada com sucesso !!");
            } else {
                System.out.println("Falha ao realizar a transferencia !!");
            }
        } else {
            System.out.println("Numero da conta(Origem ou Destino) invalido !!");
        }
    }

    public void alterarInfoCliente(Conta conta) {
        boolean exec = true;
        Cliente cliente = conta.getCliente();
        do {

            System.out.println("***** MENU DE ALTERACOES *****");
            System.out.println("1)Alterar nome");
            System.out.println("2)Alterar data de nascimento");
            System.out.println("3)Alterar endereco");
            System.out.println("0)Retornar para o menu principal");
            int opt = prompt.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("Digite o nome do cliente:");
                    String nome = prompt.nextLine();
                    prompt.nextLine();

                    cliente = new Cliente(nome, cliente.getCpfCliente(), cliente.getDataNascimento(),
                            cliente.getEndereco());

                    break;
                case 2:
                    System.out.println("Digite o dia do nascimento:");
                    int dia = prompt.nextInt();
                    System.out.println("Digite o mes do nascimento:");
                    int mes = prompt.nextInt();
                    System.out.println("Digite o ano do nascimento:");
                    int ano = prompt.nextInt();

                    prompt.nextLine();

                    if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && ano >= 1900) {
                        LocalDate novaData = LocalDate.of(ano, mes, dia);

                        cliente = new Cliente(cliente.getNomeCliente(), cliente.getCpfCliente(), novaData,
                                cliente.getEndereco());
                    } else {
                        System.out.println("Data invalida !!");
                    }
                    break;
                case 3:
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
                    System.out.println("Digite o estado:");
                    String estado = prompt.nextLine();

                    Endereco novoEndereco = new Endereco(rua, bairro, cep, cidade, numero, estado);

                    cliente.setEndereco(novoEndereco);
                    conta.setCliente(cliente);
                    break;
                case 0:
                    System.out.println("Retorndando...");
                    exec = false;
                    break;
                default:
                    throw new IllegalArgumentException("\nOpcao Invalida!!\n");
            }

        } while (exec);

    }
}