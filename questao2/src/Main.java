public class Main {
    public static void main(String[] args) {
        Lote quadro = new Lote("Quadro a óleo", "Arte", 10000.00, 15000.00, new ComissaoArte());
        Lote moto = new Lote("Moto clássica", "Veículos", 20000.00, 40000.00, new ComissaoVeiculos());

        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        quadro.acompanhar(ana);
        quadro.acompanhar(bruno);
        quadro.acompanhar(carla);
        quadro.acompanhar(painel);
        quadro.acompanhar(auditor);

        moto.acompanhar(bruno);
        moto.acompanhar(carla);
        moto.acompanhar(painel);
        moto.acompanhar(auditor);

        System.out.println("--- Lote 1: Quadro a óleo (Arte) ---");
        quadro.darLance(ana, 11000.00);
        quadro.darLance(bruno, 11200.00); // recusado: menos de 5% acima do lance atual
        quadro.darLance(bruno, 12000.00);

        System.out.println("\n--- Carla deixa de acompanhar o quadro ---");
        quadro.deixarDeAcompanhar(carla);
        quadro.darLance(ana, 16000.00);

        System.out.println("\n--- Campanha: o quadro passa a usar a regra de comissão de Eletrônicos ---");
        quadro.setRegraComissao(new ComissaoEletronicos());

        System.out.println("\n--- Encerramento do quadro ---");
        quadro.encerrar();
        quadro.darLance(bruno, 20000.00); // recusado: lote encerrado

        System.out.println("\n--- Lote 2: Moto clássica (Veículos) ---");
        moto.darLance(carla, 22000.00);
        moto.darLance(ana, 22500.00); // recusado: menos de 5% acima do lance atual
        moto.darLance(bruno, 25000.00);

        System.out.println("\n--- Encerramento da moto ---");
        moto.encerrar();

        System.out.println();
        new AcertoVendedor().imprimir(quadro.getNome(), quadro.getValorVenda(), quadro.calcularComissao());

        // Serviços adicionais do comprador: três serviços, a embalagem contratada duas vezes
        Fatura fatura = new FaturaBase(quadro.getNome(), quadro.getValorVenda());
        fatura = new SeguroTransporte(fatura);
        fatura = new CertificadoAutenticidade(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EmbalagemEspecial(fatura);

        System.out.println();
        new ImpressoraFatura().imprimir(fatura);

        System.out.println();
        auditor.imprimirRegistros();
    }
}
