// ConcreteDecorator: 1,5% do valor de venda
public class SeguroTransporte extends ServicoAdicional {

    public SeguroTransporte(Fatura fatura) {
        super(fatura);
    }

    @Override
    protected String getNomeServico() {
        return "Seguro de transporte (1,5%)";
    }

    @Override
    protected double getCusto() {
        return getValorVenda() * 0.015;
    }
}
