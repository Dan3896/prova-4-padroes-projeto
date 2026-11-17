import java.util.concurrent.atomic.AtomicInteger;

// Produto concreto do provedor Azure
public class AzureFilaMensagens implements FilaMensagens {
    public static final double CUSTO_FIXO_MENSAL = 0.50;
    private static final AtomicInteger sequencial = new AtomicInteger(0);

    private final String id;

    public AzureFilaMensagens() {
        this.id = "sb-" + sequencial.incrementAndGet();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public double getCustoFixoMensal() {
        return CUSTO_FIXO_MENSAL;
    }
}
