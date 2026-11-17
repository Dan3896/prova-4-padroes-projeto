import java.util.List;

// Ambiente provisionado: máquinas, armazenamento e fila de um mesmo provedor
public class Ambiente {
    private final String nome;
    private final String provedor;
    private final String regiao;
    private final List<MaquinaVirtual> maquinas;
    private final Armazenamento armazenamento;
    private final FilaMensagens fila;
    private final double custoMensalEstimado;

    public Ambiente(String nome, String provedor, String regiao, List<MaquinaVirtual> maquinas,
                    Armazenamento armazenamento, FilaMensagens fila, double custoMensalEstimado) {
        this.nome = nome;
        this.provedor = provedor;
        this.regiao = regiao;
        this.maquinas = maquinas;
        this.armazenamento = armazenamento;
        this.fila = fila;
        this.custoMensalEstimado = custoMensalEstimado;
    }

    public String getNome() {
        return nome;
    }

    public double getCustoMensalEstimado() {
        return custoMensalEstimado;
    }

    public String resumo() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Ambiente provisionado: ").append(nome).append(" ===\n");
        sb.append("Provedor: ").append(provedor).append("\n");
        sb.append("Região: ").append(regiao).append("\n");
        for (MaquinaVirtual maquina : maquinas) {
            sb.append("Máquina virtual: ").append(maquina.getId()).append("\n");
        }
        sb.append("Armazenamento: ").append(armazenamento.getId()).append("\n");
        sb.append("Fila de mensagens: ").append(fila.getId()).append("\n");
        sb.append(String.format("Custo mensal estimado: R$ %.2f%n", custoMensalEstimado));
        return sb.toString();
    }
}
