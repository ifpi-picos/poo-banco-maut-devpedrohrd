public class NotificacaoSMS implements Notificacao {

    @Override
    public void enviarNotificacao(String tipo, double valor) {
        System.out.println("#### NOTIFICACAO ####");
        System.out.println("Enviando notificação por SMS !! \nTipo: " + tipo + " \nValor: R$" + valor);
    }

}
