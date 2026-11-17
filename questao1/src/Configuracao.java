import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// Singleton: o config.properties é lido uma única vez e todos enxergam os mesmos valores
public class Configuracao {
    private static final String ARQUIVO = "config.properties";
    private static Configuracao instancia;

    private final String regiaoPadrao;
    private final double orcamentoMensalMaximo;

    private Configuracao() {
        Properties propriedades = new Properties();
        try (InputStream entrada = abrirArquivo()) {
            propriedades.load(entrada);
        } catch (IOException e) {
            throw new IllegalStateException("Não foi possível ler o arquivo " + ARQUIVO, e);
        }
        this.regiaoPadrao = propriedades.getProperty("regiao.padrao");
        this.orcamentoMensalMaximo = Double.parseDouble(propriedades.getProperty("orcamento.mensal.maximo"));
        System.out.println(String.format("[Configuracao] %s lido (região %s, orçamento R$ %.2f)%n",
                ARQUIVO, regiaoPadrao, orcamentoMensalMaximo));
    }

    // synchronized: mesmo com threads simultâneas, só uma instância é criada (uma única leitura)
    public static synchronized Configuracao getInstancia() {
        if (instancia == null) {
            instancia = new Configuracao();
        }
        return instancia;
    }

    // Procura o arquivo junto das classes; se não achar, tenta a pasta de execução
    private InputStream abrirArquivo() throws IOException {
        InputStream entrada = Configuracao.class.getResourceAsStream("/" + ARQUIVO);
        if (entrada != null) {
            return entrada;
        }
        String[] caminhos = { ARQUIVO, "src/" + ARQUIVO, "questao1/src/" + ARQUIVO };
        for (String caminho : caminhos) {
            if (new File(caminho).exists()) {
                return new FileInputStream(caminho);
            }
        }
        throw new IOException("Arquivo " + ARQUIVO + " não encontrado");
    }

    public String getRegiaoPadrao() {
        return regiaoPadrao;
    }

    public double getOrcamentoMensalMaximo() {
        return orcamentoMensalMaximo;
    }
}
