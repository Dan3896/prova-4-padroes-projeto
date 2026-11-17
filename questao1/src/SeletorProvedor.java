// Componente que escolhe o provedor: único ponto (além da Main) que conhece as fábricas concretas.
// Para incluir um novo provedor (ex.: Gcp), basta criar as classes novas e acrescentar um caso aqui.
public class SeletorProvedor {

    public static FabricaNuvem escolher(String provedor) {
        switch (provedor.toLowerCase()) {
            case "aws":
                return new AwsFabrica();
            case "azure":
                return new AzureFabrica();
            default:
                throw new IllegalArgumentException("Provedor desconhecido: " + provedor);
        }
    }
}
