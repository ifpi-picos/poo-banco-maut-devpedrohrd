import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private Conta conta;
    private Cliente cliente;
    private List<Cliente> listaClientes;
    private List<Conta> listaContas;

    public Sistema(Conta conta, Cliente cliente) {
        listaClientes = new ArrayList<>();
        listaContas = new ArrayList<>();
    }

    public void cadastraCliente(String nome, String cpf, String dataNascimento, String endereco) {
        Cliente novoCliente = new Cliente(nome, cpf, dataNascimento, endereco);
        listaClientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void mortrarInformacoes(Conta numeroconta, Cliente cpfCliente) {
        if (conta.getNumeroConta().equals(numeroconta.getNumeroConta())) {
            if (cliente.getCpfCliente().equals(cpfCliente.getCpfCliente())) {
                System.out.println("Numero d agencia -> " + conta.getNumeroAgencia() +
                        " Numero da conta ->" + conta.getNumeroConta() +
                        "Nome cliente ->" + cliente.getNomeCliente() +
                        "Saldo -> " + conta.getSaldo());
            }
        } else {
            System.out.println("Nao foi possivel encontrar as informacoes solicitadas");
        }
    }

    public void addClientesLista(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void removeClientesListe(Cliente cliente) {
        listaClientes.remove(cliente);
    }

    public void addContasLista(Conta conta) {
        listaContas.add(conta);
    }

    public void removeContasLista(Conta conta) {
        listaContas.remove(conta);
    }

    public Cliente encontrarClientePorCPF(String cpf) {
        for (Cliente clientes : listaClientes) {
            if (clientes.getCpfCliente().equals(cpf)) {
                return cliente;
            }
        }
        return cliente;
    }

}
