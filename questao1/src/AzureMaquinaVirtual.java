import java.util.concurrent.atomic.AtomicInteger;

// Produto concreto do provedor Azure
public class AzureMaquinaVirtual implements MaquinaVirtual {
    public static final double CUSTO_POR_HORA = 0.12;
    private static final AtomicInteger sequencial = new AtomicInteger(0);

    private final String id;

    public AzureMaquinaVirtual() {
        this.id = "vm-" + sequencial.incrementAndGet();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public double getCustoPorHora() {
        return CUSTO_POR_HORA;
    }
}
