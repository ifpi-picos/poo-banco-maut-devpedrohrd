public class Notificacao {
    public void enviarEmail(String descricao, double valor) {
        System.out.println("******* Notificacao via Email *******");
        System.out.println("Operacao realizada ->" + descricao);
        System.out.println("Valor ->" + valor);
        System.out.println("#################");
    }

    public void enviarSmS(String descricao, double valor) {
        System.out.println("******* Notificacao via SmS *******");
        System.out.println("Operacao realizada ->" + descricao);
        System.out.println("Valor ->" + valor);
        System.out.println("#################");
    }
}
