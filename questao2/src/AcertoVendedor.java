// Imprime o acerto com o vendedor usando a regra de comissão vigente no lote
public class AcertoVendedor {

    public void imprimir(String nomeLote, double valorVenda, double comissao) {
        System.out.println("===== ACERTO DO VENDEDOR =====");
        System.out.println("Lote: " + nomeLote);
        System.out.printf("Valor de venda: R$ %.2f%n", valorVenda);
        System.out.printf("Comissão cobrada: R$ %.2f%n", comissao);
        System.out.printf("Valor líquido a repassar: R$ %.2f%n", valorVenda - comissao);
    }
}
