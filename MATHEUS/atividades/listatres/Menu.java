import java.util.List;
import java.util.Scanner;


public class Menu extends App {
    static Scanner entrada = new Scanner(System.in);

    public static int exibeMenu() {
        System.out.println("selecione a opção do menu:\n[1] - registar planta\n[2] - finaliza venda\n[3]  - Exibe historico de vendas\n[4] - Lançar total do dia\n[5] - Buscar\n[0] - sair do sistema");
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
        HistoricoDeVendas.gravaArquivo(conteudo,"historicodevendas.csv");
        System.out.println("seu troco é: " + (dinheiroRecebido - valorTotalCompra) + "\n compra concluida");
        quantidadeDodia += totalDePordutos;
        valorDevendasNoDia += valorTotalCompra;
        listaDeProdutosVendidos.clear();
    }
    
    public static void finalizaSistema(int quantidade, double valorTotal, double valorInseridoPeloUsuario) {
        System.out.println("sistema finalizado aperte entre para sair...");
        String conteudo= quantidade + ";" + valorTotal + ";" + valorInseridoPeloUsuario + ";";
        String localDoArquivo = "relatoriodiario.csv";
        HistoricoDeVendas.gravaTotalDeVendasDoDia(conteudo, localDoArquivo);
        entrada.nextLine();
    }
    public static void  exibeHistorico(){

        int menu = menuDoHistorico();
        switch (menu) {
            case 1:
            HistoricoDeVendas.lerArquivo("historicodevendas.csv");
                break;
            case 2:
            HistoricoDeVendas.lerArquivo("relatoriodiario.csv");
                break;
            case 0:
                System.out.println("retornado ao menu");
                return;
            default:
            System.out.println("opção não encontrada retornando ao menu principal");
                break;
        }
    }

    private static int menuDoHistorico() {
        System.out.println("MENU DE EXIBÇÃO:\nEscolha a opção que deseja exibir:\n\n[1] - Historico de todas as vendas\n[2] - historico diario\n[0] - Retornar ao menu");
        return entrada.nextInt();
    }

    public static void lancarTotalDoDia() {
       System.out.println("digite o total do dia");
       valorInseridoPeloUsuario =  entrada.nextDouble();
       System.out.println("valor registrado");
    }

    public static void buscarPorDiaExpecifico() {
        String busca;
        int menu = menuDeBusca();
        entrada.nextLine();
        switch (menu) {
            case 1:
                System.out.println("digite qual dia ou mês está procurando Exemplo:(26-08-2024 10:49)");
                busca = entrada.nextLine();
                HistoricoDeVendas.ProcurarNoArquivo("historicodevendas.csv",busca);
                break;
            case 2:
                System.out.println("digite qual dia ou mês está procurando Exemplo:(26-08-2024 10:49)");
                busca = entrada.nextLine();
                HistoricoDeVendas.ProcurarNoArquivo("relatoriodiario.csv",busca);
                break;
            case 0:
                System.out.println("retornado ao menu");
                return;
            default:
            System.out.println("opção não encontrada retornando ao menu principal");
        }
    }


    private static int menuDeBusca() {
        System.out.println("MENU DE Busca:\nEscolha a opção em qual relatorio deseja buscar:\n\n[1] - Historico de todas as vendas\n[2] - historico diario\n[0] - Retornar ao menu");
        return entrada.nextInt();
    }
}