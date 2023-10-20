public class NotificacaoEmail implements Notificacao {

    @Override
    public void enviarNotificacao(String tipo, double valor) {
        System.out.println("Enviando notificação por email," + tipo + ",Valor:" + valor);
    }

}
