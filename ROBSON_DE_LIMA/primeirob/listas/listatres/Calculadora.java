package ROBSON_DE_LIMA.primeirob.listas.listatres;
    
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Calculadora {

    private static final double DESCONTO_ESPECIAL = 0.05;
    private static List<Venda> registroVendas = new ArrayList<>();
    private static Map<String, Integer> vendasDiarias = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println(" ---------------------------------");
            System.out.println("| Menu:                           |");
            System.out.println("| [1] - Calcular Preço Total      |");
            System.out.println("| [2] - Calcular Troco            |");
            System.out.println("| [3] - Exibir Registro de Vendas |");
            System.out.println("| [4] - Registrar Vendas Diárias  |");
            System.out.println("| [5] - Buscar Vendas por Data    |");
            System.out.println("| [6] - Sair                      |");
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
                    registrarVendasDiarias(scanner);
                    break;
                case 5:
                    buscarVendasPorData(scanner);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    public static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double precoTotal = quantidade * precoUnitario;

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

    public static void registrarVendasDiarias(Scanner scanner) {
        System.out.print("Digite o dia (DD): ");
        int dia = scanner.nextInt();
        System.out.print("Digite o mês (MM): ");
        int mes = scanner.nextInt();
        System.out.print("Digite a quantidade total de vendas do dia: ");
        int quantidadeVendas = scanner.nextInt();

        String chaveData = String.format("%02d-%02d", dia, mes);
        vendasDiarias.put(chaveData, quantidadeVendas);
        System.out.println("Vendas diárias registradas com sucesso!");
    }

    public static void buscarVendasPorData(Scanner scanner) {
        System.out.print("Digite o dia (DD): ");
        int dia = scanner.nextInt();
        System.out.print("Digite o mês (MM): ");
        int mes = scanner.nextInt();

        String chaveData = String.format("%02d-%02d", dia, mes);
        if (vendasDiarias.containsKey(chaveData)) {
            System.out.printf("Quantidade total de vendas em %02d/%02d: %d%n", dia, mes, vendasDiarias.get(chaveData));
        } else {
            System.out.println("Nenhum registro de vendas encontrado para essa data.");
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
