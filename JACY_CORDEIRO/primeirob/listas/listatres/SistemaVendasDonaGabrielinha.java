package JACY_CORDEIRO.primeirob.Listas.listatres;
import java.util.Scanner;

public class SistemaVendasDonaGabrielinha {
    private static int[][] vendasPorMes = new int[12][30]; // 12 meses, 30 dias

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("----- MENU -----");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Mostrar Registro de Vendas");
            System.out.println("[4] - Salvar Vendas Diárias");
            System.out.println("[5] - Consultar Vendas por Dia e Mês");
            System.out.println("[6] - Consultar Vendas Totais por Mês");
            System.out.println("[7] - Sair");
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
                    salvarVendasDiarias(scanner);
                    break;
                case 5:
                    consultarVendasPorDiaEMes(scanner);
                    break;
                case 6:
                    consultarVendasTotaisPorMes(scanner);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 7);

        scanner.close();
    }

    // Método para calcular o preço total com possível desconto
    private static void calcularPrecoTotal(Scanner scanner) {
        // Implementação anterior...
    }

    // Método para calcular o troco
    private static void calcularTroco(Scanner scanner) {
        // Implementação anterior...
    }

    // Método para mostrar o registro de vendas
    private static void mostrarRegistroDeVendas() {
        // Implementação anterior...
    }

    // Método para salvar vendas diárias
    private static void salvarVendasDiarias(Scanner scanner) {
        System.out.print("Digite o mês (1-12): ");
        int mes = scanner.nextInt();
        System.out.print("Digite o dia (1-30): ");
        int dia = scanner.nextInt();
        System.out.print("Digite o número total de vendas: ");
        int vendas = scanner.nextInt();

        vendasPorMes[mes - 1][dia - 1] = vendas;
        System.out.println("Vendas do dia " + dia + "/" + mes + " foram salvas com sucesso.");
    }

    // Método para consultar vendas por dia e mês
    private static void consultarVendasPorDiaEMes(Scanner scanner) {
        System.out.print("Digite o mês (1-12): ");
        int mes = scanner.nextInt();
        System.out.print("Digite o dia (1-30): ");
        int dia = scanner.nextInt();

        int vendas = vendasPorMes[mes - 1][dia - 1];
        System.out.println("Total de vendas em " + dia + "/" + mes + ": " + vendas);
    }

    // Método para consultar vendas totais por mês
    private static void consultarVendasTotaisPorMes(Scanner scanner) {
        System.out.print("Digite o mês (1-12): ");
        int mes = scanner.nextInt();

        int vendasTotais = 0;
        for (int i = 0; i < 30; i++) {
            vendasTotais += vendasPorMes[mes - 1][i];
        }
        System.out.println("Total de vendas no mês " + mes + ": " + vendasTotais);
    }
}
