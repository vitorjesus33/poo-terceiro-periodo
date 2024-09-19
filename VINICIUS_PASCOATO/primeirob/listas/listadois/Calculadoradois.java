package VINICIUS_PASCOATO.primeirob.listas.listadois;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculadoradois {

    private static List<String> registrosDeVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidade, opcao;

        do {
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Exibir Registros de Vendas");
            System.out.println("[4] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o preço unitário da planta (em centavos): ");
                    int precoUnitario = scanner.nextInt();
                    System.out.print("Digite a quantidade de plantas: ");
                    quantidade = scanner.nextInt();

                    int precoTotal = quantidade * precoUnitario;
                    int desconto = 0;

                    if (quantidade > 10) {
                        desconto = precoTotal * 5 / 100;
                        precoTotal -= desconto;
                        System.out.printf("O preço total com desconto é: R$ %d,%02d%n", precoTotal / 100,
                                precoTotal % 100);
                    } else {
                        System.out.printf("O preço total da venda é: R$ %d,%02d%n", precoTotal / 100, precoTotal % 100);
                    }
                    String registroVenda = String.format("Quantidade: %d, Valor da Venda: R$ %d,%02d, Desconto: %d%%",
                            quantidade, precoTotal / 100, precoTotal % 100, desconto * 100 / (precoTotal + desconto));
                    registrosDeVendas.add(registroVenda);
                    System.out.println("Venda registrada com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o valor recebido pelo cliente (em centavos): ");
                    int valorRecebido = scanner.nextInt();
                    System.out.print("Digite o valor total da compra (em centavos): ");
                    int valorTotal = scanner.nextInt();

                    if (valorRecebido < valorTotal) {
                        System.out.println("O valor recebido é insuficiente para cobrir o valor da compra.");
                    } else {
                        int troco = valorRecebido - valorTotal;
                        System.out.printf("O troco a ser dado ao cliente é: R$ %d,%02d%n", troco / 100, troco % 100);
                    }
                    break;
                case 3:
                    System.out.println("Registros de Vendas:");
                    for (String venda : registrosDeVendas) {
                        System.out.println(venda);
                    }
                    break;
                case 4:
                    // Sair
                    System.out.println("Saindo. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
