// Calculadora para loja de plantas da Dona Gabrielinha

package ERICK_SCUR.primeirob.listas.lista1;
import java.util.Scanner;


public class CalculadoraLojaPlantas {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;
        while (opcao != 3) {
            System.out.println("Escolha uma opção:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    calcularPrecoTotal();
                    break;
                case 2:
                    calcularTroco();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

        scanner.close();
    }

    private static void calcularPrecoTotal() {
        System.out.println("Digite a quantidade de plantas:");
        int quantidade = scanner.nextInt();
        System.out.println("Digite o preço unitário:");
        double precoUnitario = scanner.nextDouble();
        double precoTotal = quantidade * precoUnitario;
        System.out.println("Preço total: " + precoTotal);
    }

    private static void calcularTroco() {
        System.out.println("Digite o valor recebido:");
        double valorRecebido = scanner.nextDouble();
        System.out.println("Digite o valor total da compra:");
        double valorTotal = scanner.nextDouble();
        double troco = valorRecebido - valorTotal;
        System.out.println("Troco: " + troco);
    }
}
