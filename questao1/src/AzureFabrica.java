// Fábrica concreta (Abstract Factory): só cria recursos do provedor Azure
public class AzureFabrica implements FabricaNuvem {

    @Override
    public String getNomeProvedor() {
        return "Azure";
    }

    @Override
    public MaquinaVirtual criarMaquinaVirtual() {
        return new AzureMaquinaVirtual();
    }

    @Override
    public Armazenamento criarArmazenamento() {
        return new AzureArmazenamento();
    }

    @Override
    public FilaMensagens criarFilaMensagens() {
        return new AzureFilaMensagens();
    }

    @Override
    public double getCustoHoraMaquina() {
        return AzureMaquinaVirtual.CUSTO_POR_HORA;
    }

    @Override
    public double getCustoGbArmazenamento() {
        return AzureArmazenamento.CUSTO_POR_GB;
    }

    @Override
    public double getCustoFixoFila() {
        return AzureFilaMensagens.CUSTO_FIXO_MENSAL;
    }
}
