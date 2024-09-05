import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculadora2 {
    private static List<Venda> registroVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("===== Menu da Calculadora =====");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Exibir Registro de Vendas");
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
                    exibirRegistroVendas();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }

            System.out.println();
        } while (opcao != 4);

        scanner.close();
    }

    private static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade da planta: ");
        int quantidade = scanner.nextInt();

        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double precoTotal = quantidade * precoUnitario;

        if (quantidade > 10) {
            precoTotal *= 0.95; // Aplicar 5% de desconto
        }

        System.out.printf("O preço total é: R$ %.2f\n", precoTotal);

        // Registro da venda
        registroVendas.add(new Venda(quantidade, precoTotal, quantidade > 10));
    }

    private static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor pago pelo cliente: ");
        double valorPago = scanner.nextDouble();

        System.out.print("Digite o valor total da compra: ");
        double valorCompra = scanner.nextDouble();

        if (valorPago < valorCompra) {
            System.out.println("O valor pago é insuficiente para cobrir o valor da compra.");
        } else {
            double troco = valorPago - valorCompra;
            System.out.printf("O troco a ser dado ao cliente é: R$ %.2f\n", troco);
        }
    }

    private static void exibirRegistroVendas() {
        System.out.println("===== Registro de Vendas =====");
        for (Venda venda : registroVendas) {
            System.out.printf("Quantidade: %d, Valor da Venda: R$ %.2f, Desconto Aplicado: %s\n",
                    venda.getQuantidade(),
                    venda.getValorVenda(),
                    venda.isDescontoAplicado() ? "Sim" : "Não");
        }
    }
}

class Venda {
    private int quantidade;
    private double valorVenda;
    private boolean descontoAplicado;

    public Venda(int quantidade, double valorVenda, boolean descontoAplicado) {
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
        this.descontoAplicado = descontoAplicado;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public boolean isDescontoAplicado() {
        return descontoAplicado;
    }
}
