package primeirob.aulas.aulaum;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Menu--\n[1]Soma\n[2]Subtração");
        int escolha = leitor.nextInt();
        
        System.out.println("Informe valor um!");
        int valorUm = leitor.nextInt();
        
        System.out.println("Informe valor dois!");
        int valorDois = leitor.nextInt();
        
        if (escolha == 1) {
           System.out.println("Realizar soma");     
           System.out.println(valorUm + valorDois);
        }

        String valor = valorUm > valorDois ? "É maior" : "Menor";
    
        System.out.println(valor);

        leitor.close();
    }
}
