// Observer concreto: participante que acompanha lotes e também dá lances
public class Participante implements Interessado, Licitante {
    private final String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void novoLance(Lote lote, Lance lance) {
        System.out.printf("   [%s] Novo lance no lote \"%s\": R$ %.2f%n", nome, lote.getNome(), lance.getValor());
    }
}
