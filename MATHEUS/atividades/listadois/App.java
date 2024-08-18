import java.util.LinkedList;
import java.util.List;

public class App {
    
    
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
                case 0 -> {                    
                    Menu.finalizaSistema();
                }
                default -> {
                }
            }
        } while (menu != 0);
    }
}