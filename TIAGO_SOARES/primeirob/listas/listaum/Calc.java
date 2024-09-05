package primeirob.listas.listaum;

import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        System.out.println("--Menu--\n[1]Calcular Preço Total\n[2]Calcular Troco\n");
        int choice = reader.nextInt();
             
        switch (choice) {
            case 1:
                System.out.println("Calcular Preço Total\n");

                System.out.println("Informe a quantidade plantas!");
                int countPlan = reader.nextInt();

                System.out.println("Informe o preço de cada planta!");
                float valuePerPlan = reader.nextFloat();
                
                System.out.println("Preço Total: ");
                System.out.println(countPlan * valuePerPlan);
                break;
            case 2:

                System.out.println("Calcular Troco\n");

                System.out.println("Informe o valor recebido do Cliente!");
                float clientValue = reader.nextFloat();

                System.out.println("Informe o total da compra!");
                float totalValue = reader.nextFloat();
                
                System.out.println("Troco: ");
                System.out.println(clientValue - totalValue);
                break;
            default:
                break;
        }    
        reader.close();
    }
}
