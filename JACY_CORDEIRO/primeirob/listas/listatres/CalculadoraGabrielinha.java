
import java.util.Scanner;

public class CalculadoraGabrielinha {
    private static double[][] vendasMensais = new double[12][30]; // Cada mês tem 30 dias

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("----- MENU -----");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Registrar Vendas Diárias");
            System.out.println("[4] - Consultar Vendas Diárias");
            System.out.println("[5] - Sair");
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
                    registrarVendas(scanner);
                    break;
                case 4:
                    consultarVendas(scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    public static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade da planta: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();
        double precoTotal = quantidade * precoUnitario;
        System.out.println("O preço total é: R$ " + precoTotal);
    }

    public static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor recebido do cliente: ");
        double valorRecebido = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: ");
        double valorTotal = scanner.nextDouble();
        double troco = valorRecebido - valorTotal;
        System.out.println("O troco é: R$ " + troco);
    }

    public static void registrarVendas(Scanner scanner) {
        System.out.print("Digite o mês (1-12): ");
        int mes = scanner.nextInt();
        System.out.print("Digite o dia (1-30): ");
        int dia = scanner.nextInt();
        System.out.print("Digite a quantidade total de vendas do dia: ");
        double vendas = scanner.nextDouble();

        vendasMensais[mes - 1][dia - 1] = vendas;
        System.out.println("Vendas registradas com sucesso para o dia " + dia + "/" + mes);
    }

    public static void consultarVendas(Scanner scanner) {
        System.out.print("Digite o mês (1-12): ");
        int mes = scanner.nextInt();
        System.out.print("Digite o dia (1-30): ");
        int dia = scanner.nextInt();

        double vendas = vendasMensais[mes - 1][dia - 1];
        System.out.println("Vendas do dia " + dia + "/" + mes + ": " + vendas);
    }
}
