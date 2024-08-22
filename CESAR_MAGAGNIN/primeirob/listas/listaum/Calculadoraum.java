package CESAR_MAGAGNIN.primeirob.listas.listaum;
import java.util.Scanner;
public class Calculadoraum {
   public static void main (String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Menu Console:\n[1] - Calcular Preço total\n[2] - Calcular Troco\n[3] - Sair\nEscolha uma opção: ");
      int opt = scanner.nextInt();
      switch (opt) {
         case 1:
            System.out.println("\nInsira a quantidade de plantas vendidas: ");
            int qtd = scanner.nextInt();
            System.out.println("\nInsira o valor da planta: ");
            float vlr = scanner.nextFloat();
            System.out.println("\nO preço total é igual a  "+(qtd*vlr));
            break;
            case 2:
            System.out.println("\nInsira o valor pago cliente: ");
            float cliente = scanner.nextFloat();
            System.out.println("\nInsira o valor da compra: ");
            float total = scanner.nextFloat();
            System.out.printf("\nO valor do troco é igual a  %.2f%n", (cliente-total));
            break;
         default:
            System.out.println("Obrigado por usar nossa ferramenta");
            break;
      }
      scanner.close();
   }   
}
