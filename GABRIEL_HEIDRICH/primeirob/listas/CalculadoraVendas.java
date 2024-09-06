import java.util.Scanner;

public class CalculadoraVendas {

    public static double calcularPrecoTotal(double quantidade, double precoUnitario) {
        return quantidade * precoUnitario;
    }

    public static double calcularTroco(double valorRecebido, double valorCompra) {
        return valorRecebido - valorCompra;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("\n--- Bem-vindo à Calculadora da Dona Gabrielinha ---");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe a quantidade da planta: ");
                    double quantidade = scanner.nextDouble();
                    System.out.print("Informe o preço unitário da planta: ");
                    double precoUnitario = scanner.nextDouble();
                    double precoTotal = calcularPrecoTotal(quantidade, precoUnitario);
                    System.out.printf("O preço total da venda é: R$ %.2f\n", precoTotal);
                    break;

                case 2:
                    System.out.print("Informe o valor total da compra: ");
                    double valorCompra = scanner.nextDouble();
                    System.out.print("Informe o valor recebido do cliente: ");
                    double valorRecebido = scanner.nextDouble();
                    double troco = calcularTroco(valorRecebido, valorCompra);
                    if (troco < 0) {
                        System.out.println("O valor recebido é insuficiente para cobrir a compra.");
                    } else {
                        System.out.printf("O troco a ser devolvido é: R$ %.2f\n", troco);
                    }
                    break;

                case 3:
                    System.out.println("Saindo da calculadora. Obrigado!");
                    break;

                default:
                    System.out.println("Opção inválida, por favor tente novamente.");
            }
        }

        scanner.close();
    }
}