package VINICIUS_PASCOATO.primeirob.listas.listaum;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidade, opcao;

        do {

            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.println("Escolha uma opção:");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o preço unitário da planta: ");
                    int precoUnitario = scanner.nextInt();
                    System.out.print("Digite a quantidade da planta: ");
                    quantidade = scanner.nextInt();
                    int precoTotal = quantidade * precoUnitario;
                    System.out.printf("O preço total da venda é: R$ %.2f%n", precoTotal);
                    break;
                case 2:
                    System.out.print("Digite o valor recebido pelo cliente: ");
                    int valorRecebido = scanner.nextInt();
                    System.out.print("Digite o valor total da compra: ");
                    int valorTotal = scanner.nextInt();
                    if (valorRecebido < valorTotal) {
                        System.out.println("O valor recebido é insuficiente para cobrir o valor da compra.");
                    } else {
                        int troco = valorRecebido - valorTotal;
                        System.out.printf("O troco a ser dado ao cliente é: R$ %.2f%n", troco);
                    }
                    break;
                case 3:
                    System.out.println("Saindo. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);

        scanner.close();
    }
}
