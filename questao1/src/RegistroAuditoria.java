import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroAuditoria {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");

    private final LocalDateTime dataHora;
    private final String nomeAmbiente;
    private final String provedor;
    private final String resultado;

    public RegistroAuditoria(LocalDateTime dataHora, String nomeAmbiente, String provedor, String resultado) {
        this.dataHora = dataHora;
        this.nomeAmbiente = nomeAmbiente;
        this.provedor = provedor;
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return dataHora.format(FORMATO) + " | " + nomeAmbiente + " | " + provedor + " | " + resultado;
    }
}
