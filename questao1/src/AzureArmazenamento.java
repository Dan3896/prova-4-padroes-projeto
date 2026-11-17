import java.util.concurrent.atomic.AtomicInteger;

// Produto concreto do provedor Azure
public class AzureArmazenamento implements Armazenamento {
    public static final double CUSTO_POR_GB = 0.02;
    private static final AtomicInteger sequencial = new AtomicInteger(0);

    private final String id;

    public AzureArmazenamento() {
        this.id = "blob://" + sequencial.incrementAndGet();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public double getCustoPorGb() {
        return CUSTO_POR_GB;
    }
}
