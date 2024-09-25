import java.util.Scanner;

public class CalculadoraVendas {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu--");
            System.out.println("[1] Calcular Preço Total");
            System.out.println("[2] Calcular Troco");
            System.out.println("[3] Sair");
            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();

            switch(opcao) {
                case 1:
                    calcularPrecoTotal(leitor);
                    break;
                case 2:
                    calcularTroco(leitor);
                    break;
                case 3:
                    System.out.println("Encerrando a calculadora...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }

        } while(opcao != 3);

        leitor.close();
    }

    public static void calcularPrecoTotal(Scanner leitor) {
        System.out.print("Informe a quantidade de plantas: ");
        int quantidade = leitor.nextInt();

        System.out.print("Informe o preço unitário da planta: ");
        double precoUnitario = leitor.nextDouble();

        double precoTotal = quantidade * precoUnitario;
        System.out.println("O preço total é: R$ " + precoTotal);
    }

    public static void calcularTroco(Scanner leitor) {
        System.out.print("Informe o valor pago pelo cliente: ");
        double valorPago = leitor.nextDouble();

        System.out.print("Informe o valor total da compra: ");
        double valorCompra = leitor.nextDouble();

        double troco = valorPago - valorCompra;
        System.out.println("O troco a ser dado é: R$ " + troco);
    }