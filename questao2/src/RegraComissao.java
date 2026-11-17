// Strategy: regra de cálculo da comissão cobrada do vendedor
public interface RegraComissao {
    double calcular(double valorVenda);

    String getDescricao();
}
