package primeirob.listas.listaum;

import java.util.Scanner;



public class Calculadora {


    public static void main(String[] args) {
        
        try (Scanner leitor = new Scanner(System.in)) {
            do { 
                System.out.println("Menu--\n[1]Preço total\n[2]Cálculo de Troco");
            int escolha = leitor.nextInt();
            
            if (escolha == 1) {
               System.out.println("Preço total: ");     
               System.out.println(Botoes.Calcularpreco());
            }
            if (escolha == 2){
                double valorTroco = Botoes.Troco();

                System.out.println("Seu troco é: "+valorTroco);
            }
            if (escolha == 3) {
                System.out.println("Obrigado por utilizar a nossa aplicação!");
                return;
            }
            } while (true);
        }
    }
}
