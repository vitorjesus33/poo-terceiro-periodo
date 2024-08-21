import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculadora {
    
    private static final double DESCONTO_ESPECIAL = 0.05;
    private static List<Venda> registroVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println(" ---------------------------------");
            System.out.println("| Menu:                           |");
            System.out.println("| [1] - Calcular Preço Total      |");
            System.out.println("| [2] - Calcular Troco            |");
            System.out.println("| [3] - Exibir Registro de Vendas |");
            System.out.println("| [4] - Sair                      |");
            System.out.println(" ---------------------------------");
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
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    public static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double precoTotal = quantidade * precoUnitario;

        // Aplicar desconto se a quantidade for maior que 10
        if (quantidade > 10) {
            double desconto = precoTotal * DESCONTO_ESPECIAL;
            precoTotal -= desconto;
            System.out.printf("Desconto especial de 5%% aplicado. Preço com desconto: R$ %.2f%n", precoTotal);
            registrarVenda(quantidade, precoUnitario, desconto, precoTotal);
        } else {
            System.out.printf("O preço total é: R$ %.2f%n", precoTotal);
            registrarVenda(quantidade, precoUnitario, 0, precoTotal);
        }
    }

    public static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor recebido: ");
        double valorRecebido = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: ");
        double valorTotal = scanner.nextDouble();

        double troco = valorRecebido - valorTotal;
        if (troco < 0) {
            System.out.println("Valor recebido é insuficiente.");
        } else {
            System.out.printf("O troco é: R$ %.2f%n", troco);
        }
    }

    public static void registrarVenda(int quantidade, double precoUnitario, double desconto, double valorTotal) {
        Venda venda = new Venda(quantidade, precoUnitario, desconto, valorTotal);
        registroVendas.add(venda);
    }

    public static void exibirRegistroVendas() {
        System.out.println("Registro de Vendas:");
        for (Venda venda : registroVendas) {
            System.out.println(venda);
        }
        if (registroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        }
    }
}

class Venda {
    private int quantidade;
    private double precoUnitario;
    private double desconto;
    private double valorTotal;

    public Venda(int quantidade, double precoUnitario, double desconto, double valorTotal) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.desconto = desconto;
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return String.format("Quantidade: %d, Preço Unitário: R$ %.2f, Desconto: R$ %.2f, Valor Total: R$ %.2f",
                             quantidade, precoUnitario, desconto, valorTotal);
    }
}
