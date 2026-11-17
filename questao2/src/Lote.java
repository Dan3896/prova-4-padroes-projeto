import java.util.ArrayList;
import java.util.List;

// Subject (Observer) e Context (Strategy)
public class Lote {
    private static final double INCREMENTO_MINIMO = 1.05;

    private final String nome;
    private final String categoria;
    private final double precoInicial;
    private final double precoReserva;
    private double lanceAtual;
    private boolean aberto = true;
    private boolean vendido = false;
    private RegraComissao regraComissao;
    private final List<Lance> lances = new ArrayList<>();
    private final List<Interessado> interessados = new ArrayList<>();

    public Lote(String nome, String categoria, double precoInicial, double precoReserva,
                RegraComissao regraComissao) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.lanceAtual = precoInicial;
        this.regraComissao = regraComissao;
    }

    // ----- Acompanhamento (Observer) -----

    public void acompanhar(Interessado interessado) {
        interessados.add(interessado);
    }

    public void deixarDeAcompanhar(Interessado interessado) {
        interessados.remove(interessado);
    }

    private void notificar(Lance lance) {
        for (Interessado interessado : interessados) {
            // quem deu o lance não precisa ser avisado do próprio lance
            if (interessado != lance.getParticipante()) {
                interessado.novoLance(this, lance);
            }
        }
    }

    // ----- Lances -----

    public boolean darLance(Licitante participante, double valor) {
        if (!aberto) {
            System.out.printf("Lance de R$ %.2f de %s RECUSADO: o lote \"%s\" está encerrado.%n",
                    valor, participante.getNome(), nome);
            return false;
        }
        double minimo = lanceAtual * INCREMENTO_MINIMO;
        if (valor < minimo) {
            System.out.printf("Lance de R$ %.2f de %s RECUSADO no lote \"%s\": "
                    + "o mínimo é R$ %.2f (5%% acima do lance atual de R$ %.2f).%n",
                    valor, participante.getNome(), nome, minimo, lanceAtual);
            return false;
        }
        Lance lance = new Lance(participante, valor);
        lances.add(lance);
        lanceAtual = valor;
        System.out.printf("Lance de R$ %.2f de %s ACEITO no lote \"%s\".%n",
                valor, participante.getNome(), nome);
        notificar(lance);
        return true;
    }

    public void encerrar() {
        aberto = false;
        vendido = !lances.isEmpty() && lanceAtual >= precoReserva;
        if (vendido) {
            System.out.printf("Lote \"%s\" VENDIDO para %s por R$ %.2f.%n",
                    nome, getMaiorLance().getParticipante().getNome(), lanceAtual);
        } else {
            System.out.printf("Lote \"%s\" NÃO VENDIDO: o maior lance (R$ %.2f) "
                    + "não atingiu o preço de reserva (R$ %.2f).%n", nome, lanceAtual, precoReserva);
        }
    }

    // ----- Comissão (Strategy) -----

    public void setRegraComissao(RegraComissao regraComissao) {
        this.regraComissao = regraComissao;
    }

    public double calcularComissao() {
        return regraComissao.calcular(getValorVenda());
    }

    // ----- Consultas -----

    public double getValorVenda() {
        return vendido ? lanceAtual : 0;
    }

    public Lance getMaiorLance() {
        return lances.isEmpty() ? null : lances.get(lances.size() - 1);
    }

    public int getTotalLances() {
        return lances.size();
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecoInicial() {
        return precoInicial;
    }

    public double getPrecoReserva() {
        return precoReserva;
    }

    public double getLanceAtual() {
        return lanceAtual;
    }

    public boolean isAberto() {
        return aberto;
    }

    public boolean isVendido() {
        return vendido;
    }
}
