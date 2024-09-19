package primeirob.listas.listacinco;

public class TestObjects {
    
    public static void main(String[] args) {

        Vendedor vendedorUm = vendedorPadraoUm();
        Vendedor vendedorDois = vendedorPadraoDois();
        
    }

    public static Vendedor vendedorPadraoUm() {
        Vendedor vendedor = new Vendedor();

        vendedor.nome = "Sandrolax";
        vendedor.idade = 20;

        return vendedor;
    }

    public static Vendedor vendedorPadraoDois() {
        Vendedor vendedor = new Vendedor();

        vendedor.nome = "Roberto";
        vendedor.idade = 49;

        return vendedor;
    }

}
