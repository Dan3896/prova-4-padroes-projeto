// Observer concreto: painel que mostra o maior lance e o total de lances do lote
public class PainelLeiloeiro implements Interessado {

    @Override
    public void novoLance(Lote lote, Lance lance) {
        System.out.printf("   [Painel] Lote \"%s\" | maior lance: R$ %.2f (%s) | total de lances: %d%n",
                lote.getNome(), lote.getLanceAtual(), lote.getMaiorLance().getParticipante().getNome(),
                lote.getTotalLances());
    }
}
