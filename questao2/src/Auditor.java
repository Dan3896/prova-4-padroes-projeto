import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// Observer concreto: registra todos os lances aceitos com data e hora
public class Auditor implements Interessado {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final List<String> registros = new ArrayList<>();

    @Override
    public void novoLance(Lote lote, Lance lance) {
        String registro = String.format("%s | lote \"%s\" | %s | R$ %.2f", LocalDateTime.now().format(FORMATO),
                lote.getNome(), lance.getParticipante().getNome(), lance.getValor());
        registros.add(registro);
        System.out.println("   [Auditor] Registrado: " + registro);
    }

    public void imprimirRegistros() {
        System.out.println("Registros do auditor (" + registros.size() + " lances aceitos):");
        for (String registro : registros) {
            System.out.println("   " + registro);
        }
    }
}
