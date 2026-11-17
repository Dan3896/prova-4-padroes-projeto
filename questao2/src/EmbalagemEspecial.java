// ConcreteDecorator: R$ 180,00 fixos
public class EmbalagemEspecial extends ServicoAdicional {

    public EmbalagemEspecial(Fatura fatura) {
        super(fatura);
    }

    @Override
    protected String getNomeServico() {
        return "Embalagem especial";
    }

    @Override
    protected double getCusto() {
        return 180.00;
    }
}
