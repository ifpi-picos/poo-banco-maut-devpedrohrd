public class NotificacaoSMS implements Notificacao {

    @Override
    public void enviarNotificacao(String tipo, double valor) {
        System.out.println("Enviando notificação por SMS," + tipo + ",Valor:" + valor);
    }

}
