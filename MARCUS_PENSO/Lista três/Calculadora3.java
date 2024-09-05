import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculadora3 {
    private static Map<String, Integer> vendasPorDia = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Salvar Vendas do Dia");
            System.out.println("[4] - Buscar Vendas por Dia e Mês");
            System.out.println("[5] - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    salvarVendasDoDia(scanner);
                    break;
                case 4:
                    buscarVendasPorDia(scanner);
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println(); // Espaço em branco para separação
        }
    }

    private static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário: ");
        double precoUnitario = scanner.nextDouble();

        double valorTotal = quantidade * precoUnitario;
        System.out.printf("O preço total é: R$ %.2f%n", valorTotal);
    }

    private static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor total da compra: ");
        double valorCompra = scanner.nextDouble();
        System.out.print("Digite o valor pago pelo cliente: ");
        double valorPago = scanner.nextDouble();

        if (valorPago >= valorCompra) {
            double troco = valorPago - valorCompra;
            System.out.printf("O troco a ser dado é: R$ %.2f%n", troco);
        } else {
            System.out.println("Valor pago é insuficiente para cobrir o valor da compra.");
        }
    }

    private static void salvarVendasDoDia(Scanner scanner) {
        System.out.print("Digite o mês (1-12): ");
        int mes = scanner.nextInt();
        System.out.print("Digite o dia (1-30): ");
        int dia = scanner.nextInt();
        System.out.print("Digite a quantidade total de vendas: ");
        int quantidadeVendas = scanner.nextInt();

        String chave = mes + "-" + dia;
        vendasPorDia.put(chave, quantidadeVendas);

        System.out.println("Vendas salvas para o dia " + dia + " do mês " + mes);
    }

    private static void buscarVendasPorDia(Scanner scanner) {
        System.out.print("Digite o mês (1-12): ");
        int mes = scanner.nextInt();
        System.out.print("Digite o dia (1-30): ");
        int dia = scanner.nextInt();

        String chave = mes + "-" + dia;
        Integer quantidadeVendas = vendasPorDia.get(chave);

        if (quantidadeVendas != null) {
            System.out.println("Quantidade de vendas no dia " + dia + " do mês " + mes + ": " + quantidadeVendas);
        } else {
            System.out.println("Nenhuma venda registrada para o dia " + dia + " do mês " + mes);
        }
    }
}
