import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Singleton: histórico único do programa, seguro para provisionamentos simultâneos
public class HistoricoAuditoria {
    private static HistoricoAuditoria instancia;

    private final List<RegistroAuditoria> registros = new ArrayList<>();

    private HistoricoAuditoria() {
    }

    public static synchronized HistoricoAuditoria getInstancia() {
        if (instancia == null) {
            instancia = new HistoricoAuditoria();
        }
        return instancia;
    }

    // synchronized: uma thread registra por vez, então nenhum registro é perdido ou sobrescrito
    public synchronized void registrar(String nomeAmbiente, String provedor, String resultado) {
        registros.add(new RegistroAuditoria(LocalDateTime.now(), nomeAmbiente, provedor, resultado));
    }

    public synchronized int getTotalRegistros() {
        return registros.size();
    }

    public synchronized void imprimir() {
        System.out.println("=== Histórico de auditoria (" + registros.size() + " registros) ===");
        for (RegistroAuditoria registro : registros) {
            System.out.println(registro);
        }
    }
}
