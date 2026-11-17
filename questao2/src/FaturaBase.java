// ConcreteComponent (Decorator): fatura só com o lote e o valor de venda
public class FaturaBase implements Fatura {
    private final String nomeLote;
    private final double valorVenda;

    public FaturaBase(String nomeLote, double valorVenda) {
        this.nomeLote = nomeLote;
        this.valorVenda = valorVenda;
    }

    @Override
    public String getDescricao() {
        return "Lote: " + nomeLote + String.format("%nValor de venda: R$ %.2f", valorVenda);
    }

    @Override
    public double getValorVenda() {
        return valorVenda;
    }

    @Override
    public double getTotal() {
        return valorVenda;
    }
}
