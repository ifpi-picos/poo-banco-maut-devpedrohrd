import java.util.Scanner;

public class Cliente {
    private String nomeCliente;
    private String cpfCliente;
    private String dataNascimento;
    private String endereco;

    Scanner prompt = new Scanner(System.in);

    public Cliente(String nomeCliente, String cpfCliente, String dataNascimento, String endereco) {
        this.endereco = endereco;
        this.cpfCliente = cpfCliente;
        this.dataNascimento = dataNascimento;
        this.nomeCliente = nomeCliente;

    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Cliente cadastraCliente() {
        System.out.println("Digite o nome do cliente:");
        String nome = prompt.nextLine();
        System.out.println("Digite o cpf do cliente:");
        String cpf = prompt.nextLine();
        System.out.println("Digite o endereco do cliente:");
        String endereco = prompt.nextLine();
        System.out.println("Digite a data de nascimento do cliente:");
        String dataNascimento = prompt.nextLine();

        Cliente cliente = new Cliente(nome, cpf, dataNascimento, endereco);
        return cliente;
    }
}