import java.util.concurrent.atomic.AtomicInteger;

// Produto concreto do provedor Aws
public class AwsMaquinaVirtual implements MaquinaVirtual {
    public static final double CUSTO_POR_HORA = 0.10;
    private static final AtomicInteger sequencial = new AtomicInteger(0);

    private final String id;

    public AwsMaquinaVirtual() {
        this.id = "i-" + sequencial.incrementAndGet();
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
