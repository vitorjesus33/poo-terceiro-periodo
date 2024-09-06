package DIONATAN_DARIZ.primeirob.aulas.listas.listadois;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculadora {
    private static List<Venda> registroDeVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Visualizar Registro de Vendas");
            System.out.println("[4] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Digite a quantidade de plantas: ");
                int quantidade = scanner.nextInt();

                System.out.print("Digite o preço unitário da planta: ");
                double precoUnitario = scanner.nextDouble();

                double precoTotal = quantidade * precoUnitario;
                double desconto = 0;

                if (quantidade > 10) {
                    desconto = precoTotal * 0.05;
                    precoTotal -= desconto;
                    System.out.println("Desconto aplicado: R$ " + desconto);
                }

                System.out.println("Preço Total: R$ " + precoTotal);

                Venda venda = new Venda(quantidade, precoTotal, desconto);
                registroDeVendas.add(venda);
                System.out.println("Venda registrada.");
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
                System.out.println("Registro de Vendas:");
                for (Venda venda : registroDeVendas) {
                    System.out.println(venda);
                }
            } else if (opcao == 4) {
                System.out.println("Encerrando o programa...");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}

class Venda {
    int quantidade;
    double valorVenda;
    double desconto;

    public Venda(int quantidade, double valorVenda, double desconto) {
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return "Quantidade: " + quantidade + ", Valor: R$ " + valorVenda + ", Desconto: R$ " + desconto;
    }
}