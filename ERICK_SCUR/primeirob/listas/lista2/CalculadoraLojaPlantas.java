package ERICK_SCUR.primeirob.listas.lista2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculadoraLojaPlantas {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<String> registroVendas = new ArrayList<>();

    public static void main(String[] args) {
        int opcao = 0;
        while (opcao != 4) {
            System.out.println("Escolha uma opção:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Registrar Venda");
            System.out.println("[4] - Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal();
                    break;
                case 2:
                    calcularTroco();
                    break;
                case 3:
                    registrarVenda();
                    break;
                case 4:
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
        double precoTotal = calcularValorTotalComDesconto(quantidade, precoUnitario);
        System.out.println("Preço total: R$ " + precoTotal);
    }

    private static double calcularValorTotalComDesconto(int quantidade, double precoUnitario) {
        double precoTotal = quantidade * precoUnitario;
        if (quantidade > 10) {
            precoTotal *= 0.95;
            System.out.println("Desconto especial de 5% aplicado!");
        }
        return precoTotal;
    }

    private static void calcularTroco() {
        System.out.println("Digite o valor recebido:");
        double valorRecebido = scanner.nextDouble();
        System.out.println("Digite o valor total da compra:");
        double valorTotal = scanner.nextDouble();
        double troco = valorRecebido - valorTotal;
        System.out.println("Troco: R$ " + troco);
    }

    private static void registrarVenda() {
        System.out.println("Digite a quantidade de plantas:");
        int quantidade = scanner.nextInt();
        System.out.println("Digite o preço unitário:");
        double precoUnitario = scanner.nextDouble();
        double valorTotal = calcularValorTotalComDesconto(quantidade, precoUnitario);

        String venda = "Quantidade: " + quantidade + ", Preço unitário: R$ " + precoUnitario +
                ", Valor total: R$ " + valorTotal +
                (quantidade > 10 ? " (Desconto aplicado)" : "");

        registroVendas.add(venda);

        System.out.println("Venda registrada com sucesso!");
        System.out.println(venda);
    }
}