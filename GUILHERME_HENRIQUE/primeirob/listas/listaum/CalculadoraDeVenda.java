import java.util.Scanner;

public class CalculadoraDeVenda {

    public static double calcularPrecoTotal(int quantidade, double precoUnitario) {
        return quantidade * precoUnitario;
    }

    public static double calcularTroco(double valorPago, double valorTotal) {
        return valorPago - valorTotal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;
        
        do {
            System.out.println("Menu:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.print("Escolha uma opção: ");
            
            escolha = scanner.nextInt();
            
            switch (escolha) {
                case 1:
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Digite o preço unitário: ");
                    double precoUnitario = scanner.nextDouble();
                    double precoTotal = calcularPrecoTotal(quantidade, precoUnitario);
                    System.out.printf("O preço total é: R$ %.2f%n", precoTotal);
                    break;
                    
                case 2:
                    System.out.print("Digite o valor pago: ");
                    double valorPago = scanner.nextDouble();
                    System.out.print("Digite o valor total da compra: ");
                    double valorTotal = scanner.nextDouble();
                    double troco = calcularTroco(valorPago, valorTotal);
                    System.out.printf("O troco a ser dado é: R$ %.2f%n", troco);
                    break;
                    
                case 3:
                    // Sair
                    System.out.println("Saindo...");
                    break;
                    
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
            
        } while (escolha != 3);
        
        scanner.close();
    }
}
