public class Main {
    public static void main(String[] args) throws InterruptedException {
        Solicitacao loja = new Solicitacao("loja-producao", "Aws", 2, 100);
        Solicitacao relatorios = new Solicitacao("relatorios", "Aws", 1, 500);
        Solicitacao portal = new Solicitacao("portal-interno", "Azure", 3, 200);
        Solicitacao bigData = new Solicitacao("big-data", "Azure", 10, 1000);

        // Dois provisionamentos na Aws disparados ao mesmo tempo, em threads distintas
        Thread t1 = new Thread(() -> provisionar(loja));
        Thread t2 = new Thread(() -> provisionar(relatorios));
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // Um provisionamento no Azure
        provisionar(portal);

        // Um provisionamento recusado por ultrapassar o orçamento
        provisionar(bigData);

        HistoricoAuditoria.getInstancia().imprimir();
    }

    private static void provisionar(Solicitacao solicitacao) {
        FabricaNuvem fabrica = SeletorProvedor.escolher(solicitacao.getProvedor());
        Provisionador provisionador = new Provisionador(fabrica);
        provisionador.provisionar(solicitacao);
    }
}
