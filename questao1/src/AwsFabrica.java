// Fábrica concreta (Abstract Factory): só cria recursos do provedor Aws
public class AwsFabrica implements FabricaNuvem {

    @Override
    public String getNomeProvedor() {
        return "Aws";
    }

    @Override
    public MaquinaVirtual criarMaquinaVirtual() {
        return new AwsMaquinaVirtual();
    }

    @Override
    public Armazenamento criarArmazenamento() {
        return new AwsArmazenamento();
    }

    @Override
    public FilaMensagens criarFilaMensagens() {
        return new AwsFilaMensagens();
    }

    @Override
    public double getCustoHoraMaquina() {
        return AwsMaquinaVirtual.CUSTO_POR_HORA;
    }

    @Override
    public double getCustoGbArmazenamento() {
        return AwsArmazenamento.CUSTO_POR_GB;
    }

    @Override
    public double getCustoFixoFila() {
        return AwsFilaMensagens.CUSTO_FIXO_MENSAL;
    }
}
