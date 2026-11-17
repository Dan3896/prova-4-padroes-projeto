// Fábrica abstrata (Abstract Factory): cria a família de recursos de um único provedor
public interface FabricaNuvem {
    String getNomeProvedor();

    MaquinaVirtual criarMaquinaVirtual();

    Armazenamento criarArmazenamento();

    FilaMensagens criarFilaMensagens();

    // Tabela de preços do provedor, usada para estimar o custo antes de criar qualquer recurso
    double getCustoHoraMaquina();

    double getCustoGbArmazenamento();

    double getCustoFixoFila();
}
