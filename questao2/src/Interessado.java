// Observer: qualquer um que queira ser avisado dos lances aceitos de um lote
public interface Interessado {
    void novoLance(Lote lote, Lance lance);
}
