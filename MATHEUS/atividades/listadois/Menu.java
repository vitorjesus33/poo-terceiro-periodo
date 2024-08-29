import java.util.List;
import java.util.Scanner;


public class Menu extends App {
    static Scanner entrada = new Scanner(System.in);

    public static int exibeMenu() {
        System.out.println("selecione a opção do menu:\n[1] - registar planta\n[2] - finaliza venda\n[3] - Exibe historico de vendas\n[0] - sair do sistema");
        return entrada.nextInt();
    }

    public static void gravaVenda(List<Produto> lista) {
        Produto compra = new Produto();
        System.out.println("digite o valor da planta comprada...");
        compra.valorUnitarioPlanta = entrada.nextDouble();
        System.out.println("quantidade de plantas compradas");
        compra.quantidadePlanta = entrada.nextInt();
        lista.add(compra);
    }

    public static void finalizaVenda(List<Produto> listaDeProdutosVendidos) {
        double valorTotalCompra = 0;
        int totalDePordutos = 0;
        String descontoAplicado = "";
        for(Produto produto : listaDeProdutosVendidos){
            valorTotalCompra += produto.getValorTotalProduto();
            totalDePordutos += produto.quantidadePlanta;
        }
        if (totalDePordutos >= 10) {
            valorTotalCompra = valorTotalCompra * 0.90;
            System.out.println("Aplicando desconto promocional de 10%");
            descontoAplicado = "10%";
        }
        System.out.println("valor total da compra = " + valorTotalCompra + "\nDigite o valor pago");
        double dinheiroRecebido = entrada.nextDouble();
            if (dinheiroRecebido < valorTotalCompra) {
            System.out.println("Pagamento insuficiente, valor faltante " + (valorTotalCompra - dinheiroRecebido));
            return;
            }
        String conteudo = valorTotalCompra + ";" + totalDePordutos + ";" + descontoAplicado;
        HistoricoDeVendas.gravaArquivo(conteudo);
        System.out.println("seu troco é: " + (dinheiroRecebido - valorTotalCompra) + "\n compra concluida");
        listaDeProdutosVendidos.clear();
    }

    public static void finalizaSistema() {
        System.out.println("sistema finalizado aperte entre para sair...");
        entrada.nextLine();
    }
    public static void  exibeHistorico(){
        HistoricoDeVendas.lerArquivo();
    }
}