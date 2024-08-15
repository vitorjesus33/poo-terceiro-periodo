import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("===== Menu da Calculadora =====");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }

            System.out.println();
        } while (opcao != 3);

        scanner.close();
    }

    private static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade da planta: ");
        int quantidade = scanner.nextInt();

        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double precoTotal = quantidade * precoUnitario;
        System.out.printf("O preço total é: R$ %.2f\n", precoTotal);
    }

    private static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor pago pelo cliente: ");
        double valorPago = scanner.nextDouble();

        System.out.print("Digite o valor total da compra: ");
        double valorCompra = scanner.nextDouble();

        if (valorPago < valorCompra) {
            System.out.println("O valor pago é insuficiente para cobrir o valor da compra.");
        } else {
            double troco = valorPago - valorCompra;
            System.out.printf("O troco a ser dado ao cliente é: R$ %.2f\n", troco);
        }
    }
}