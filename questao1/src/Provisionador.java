import java.util.ArrayList;
import java.util.List;

// Cliente da Abstract Factory: monta o ambiente conhecendo apenas as interfaces.
// Como todos os recursos saem da mesma fábrica, não há como misturar provedores.
public class Provisionador {
    private static final int HORAS_POR_MES = 730;

    private final FabricaNuvem fabrica;

    public Provisionador(FabricaNuvem fabrica) {
        this.fabrica = fabrica;
    }

    public Ambiente provisionar(Solicitacao solicitacao) {
        Configuracao configuracao = Configuracao.getInstancia();
        HistoricoAuditoria historico = HistoricoAuditoria.getInstancia();
        String provedor = fabrica.getNomeProvedor();

        double custo = estimarCustoMensal(solicitacao);
        double orcamento = configuracao.getOrcamentoMensalMaximo();

        if (custo > orcamento) {
            String motivo = String.format("custo estimado de R$ %.2f ultrapassa o orçamento de R$ %.2f",
                    custo, orcamento);
            historico.registrar(solicitacao.getNomeAmbiente(), provedor, "RECUSADO (" + motivo + ")");
            System.out.println("=== Solicitação recusada: " + solicitacao.getNomeAmbiente() + " ===\n"
                    + "Provedor: " + provedor + "\nMotivo: " + motivo + "\n");
            return null;
        }

        List<MaquinaVirtual> maquinas = new ArrayList<>();
        for (int i = 0; i < solicitacao.getQuantidadeMaquinas(); i++) {
            maquinas.add(fabrica.criarMaquinaVirtual());
        }
        Armazenamento armazenamento = fabrica.criarArmazenamento();
        FilaMensagens fila = fabrica.criarFilaMensagens();

        Ambiente ambiente = new Ambiente(solicitacao.getNomeAmbiente(), provedor,
                configuracao.getRegiaoPadrao(), maquinas, armazenamento, fila, custo);

        historico.registrar(solicitacao.getNomeAmbiente(), provedor, "ACEITO");
        System.out.println(ambiente.resumo());
        return ambiente;
    }

    private double estimarCustoMensal(Solicitacao solicitacao) {
        double custoMaquinas = solicitacao.getQuantidadeMaquinas() * fabrica.getCustoHoraMaquina() * HORAS_POR_MES;
        double custoArmazenamento = solicitacao.getGbArmazenamento() * fabrica.getCustoGbArmazenamento();
        return custoMaquinas + custoArmazenamento + fabrica.getCustoFixoFila();
    }
}
