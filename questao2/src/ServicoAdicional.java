// Decorator: envolve uma fatura e acrescenta a descrição e o custo de um serviço
public abstract class ServicoAdicional implements Fatura {
    protected final Fatura fatura;

    protected ServicoAdicional(Fatura fatura) {
        this.fatura = fatura;
    }

    protected abstract String getNomeServico();

    protected abstract double getCusto();

    @Override
    public String getDescricao() {
        return fatura.getDescricao() + String.format("%n + %s: R$ %.2f", getNomeServico(), getCusto());
    }

    @Override
    public double getValorVenda() {
        return fatura.getValorVenda();
    }

    @Override
    public double getTotal() {
        return fatura.getTotal() + getCusto();
    }
}
