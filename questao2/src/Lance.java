public class Lance {
    private final Licitante participante;
    private final double valor;

    public Lance(Licitante participante, double valor) {
        this.participante = participante;
        this.valor = valor;
    }

    public Licitante getParticipante() {
        return participante;
    }

    public double getValor() {
        return valor;
    }
}
