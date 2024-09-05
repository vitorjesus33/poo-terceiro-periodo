import java.util.LinkedList;
import java.util.List; 

public class App {
    static int quantidadeDodia = 0;
    static double valorDevendasNoDia = 0;
    static double valorInseridoPeloUsuario = 0;
    
    public static void main(String[] args) throws Exception {
        List<Produto> listaDeProdutos = new LinkedList<>();
        int menu;

        do {
            menu = Menu.exibeMenu();

            switch (menu) {
                case 1 -> {
                    Menu.gravaVenda(listaDeProdutos);
                }
                case 2 -> {
                    Menu.finalizaVenda(listaDeProdutos);
                }
                case 3 ->{
                    Menu.exibeHistorico();
                }
                case 4 -> {
                    Menu.lancarTotalDoDia();
                }
                case 5 -> {
                    Menu.buscarPorDiaExpecifico();
                }
                case 0 -> {                    
                    Menu.finalizaSistema(quantidadeDodia,valorDevendasNoDia, valorInseridoPeloUsuario);
                }
                default -> {
                }
            }
        } while (menu != 0);
    }
}