// Imprime qualquer fatura da mesma forma, com ou sem serviços adicionais
public class ImpressoraFatura {

    public void imprimir(Fatura fatura) {
        System.out.println("===== FATURA DO COMPRADOR =====");
        System.out.println(fatura.getDescricao());
        System.out.printf("Total a pagar: R$ %.2f%n", fatura.getTotal());
    }
}
