package DIONATAN_DARIZ.primeirob.aulas.listas.DonaGabrielinha;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Digite a quantidade de plantas: ");
                int quantidade = scanner.nextInt();

                System.out.print("Digite o preço unitário da planta: ");
                double precoUnitario = scanner.nextDouble();

                double precoTotal = quantidade * precoUnitario;
                System.out.println("Preço Total: R$ " + precoTotal);
            } else if (opcao == 2) {
                System.out.print("Digite o valor recebido do cliente: ");
                double valorRecebido = scanner.nextDouble();

                System.out.print("Digite o valor total da compra: ");
                double valorTotal = scanner.nextDouble();

                if (valorRecebido < valorTotal) {
                    double valorFaltante = valorTotal - valorRecebido;
                    System.out.println("Erro: Dinheiro insuficiente. Faltam R$ " + valorFaltante);
                } else {
                    double troco = valorRecebido - valorTotal;
                    System.out.println("Troco: R$ " + troco);
                }
            } else if (opcao == 3) {
                System.out.println("Encerrando o programa...");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
