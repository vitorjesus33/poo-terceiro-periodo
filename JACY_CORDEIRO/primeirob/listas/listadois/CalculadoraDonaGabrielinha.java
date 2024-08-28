package JACY_CORDEIRO.primeirob.listas.listadois;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe para armazenar informações de cada venda
class Venda {
    int quantidade;
    double valorVenda;
    double descontoAplicado;

    public Venda(int quantidade, double valorVenda, double descontoAplicado) {
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
        this.descontoAplicado = descontoAplicado;
    }

    @Override
    public String toString() {
        return "Quantidade: " + quantidade + ", Valor da Venda: R$ " + valorVenda + ", Desconto Aplicado: R$ " + descontoAplicado;
    }
}

// Classe principal da calculadora
public class CalculadoraDonaGabrielinha {
    private static List<Venda> registroVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("----- MENU -----");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Mostrar Registro de Vendas");
            System.out.println("[4] - Sair");
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
                    mostrarRegistroDeVendas();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    // Método para calcular o preço total com possível desconto
    private static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade da planta: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double desconto = 0.0;
        double precoTotal = quantidade * precoUnitario;

        if (quantidade > 10) {
            desconto = precoTotal * 0.05;  // 5% de desconto
            precoTotal -= desconto;
        }

        registroVendas.add(new Venda(quantidade, precoTotal, desconto));

        System.out.println("O preço total com desconto é: R$ " + precoTotal);
    }

    // Método para calcular o troco
    private static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor recebido do cliente: ");
        double valorRecebido = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: ");
        double valorTotal = scanner.nextDouble();

        double troco = valorRecebido - valorTotal;
        System.out.println("O troco é: R$ " + troco);
    }

    // Método para mostrar o registro de vendas
    private static void mostrarRegistroDeVendas() {
        if (registroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            System.out.println("----- REGISTRO DE VENDAS -----");
            for (Venda venda : registroVendas) {
                System.out.println(venda);
            }
        }
    }
}


