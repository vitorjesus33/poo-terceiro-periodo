import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculadoraSimples {

    // Classe para registrar cada venda
    static class Venda {
        int quantidade;
        double valorTotal;
        double desconto;

        public Venda(int quantidade, double valorTotal, double desconto) {
            this.quantidade = quantidade;
            this.valorTotal = valorTotal;
            this.desconto = desconto;
        }

        @Override
        public String toString() {
            return "Quantidade: " + quantidade +
                   ", Valor Total: R$ " + String.format("%.2f", valorTotal) +
                   ", Desconto: R$ " + String.format("%.2f", desconto);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Venda> vendas = new ArrayList<>();
        int opcao;

        while (true) {
            System.out.println("Menu:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Exibir Registro de Vendas");
            System.out.println("[4] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Digite a quantidade da planta: ");
                int quantidade = scanner.nextInt();
                System.out.print("Digite o preço unitário da planta: ");
                double precoUnitario = scanner.nextDouble();

                double valorTotal = quantidade * precoUnitario;
                double desconto = 0;

                if (quantidade > 10) {
                    desconto = valorTotal * 0.05;
                    valorTotal -= desconto;
                }

                vendas.add(new Venda(quantidade, valorTotal, desconto));
                System.out.printf("O preço total é: R$ %.2f%n", valorTotal);

            } else if (opcao == 2) {
                System.out.print("Digite o valor pago pelo cliente: ");
                double valorPago = scanner.nextDouble();
                System.out.print("Digite o valor total da compra: ");
                double valorCompra = scanner.nextDouble();

                double troco = valorPago - valorCompra;
                System.out.printf("O troco a ser dado é: R$ %.2f%n", troco);

            } else if (opcao == 3) {
                if (vendas.isEmpty()) {
                    System.out.println("Nenhuma venda registrada.");
                } else {
                    System.out.println("Registro de Vendas:");
                    for (Venda venda : vendas) {
                        System.out.println(venda);
                    }
                }

            } else if (opcao == 4) {
                System.out.println("Saindo do programa...");
                break;

            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println(); // Espaço em branco para separação
        }

        scanner.close();
    }
}
