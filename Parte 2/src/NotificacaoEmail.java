public class NotificacaoEmail implements Notificacao {

    @Override
    public void enviarNotificacao(String tipo, double valor) {
        System.out.println("\n#### NOTIFICACAO ####");
        System.out.println("Enviando notificação por email !! \nTipo:" + tipo + " \nValor: R$" + valor);
    }

}
