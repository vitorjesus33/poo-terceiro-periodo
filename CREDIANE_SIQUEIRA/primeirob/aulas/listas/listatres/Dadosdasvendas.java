import java.util.Scanner;

public class Dadosdasvendas {
    
    private static int[][] vendas = new int[12][30];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            
            System.out.println("\n--- Menu de Controle de Vendas ---");
            System.out.println("1. Registrar Vendas Diárias");
            System.out.println("2. Buscar Vendas Totais de um Dia");
            System.out.println("3. Buscar Vendas Totais de um Mês");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    registrarVendas(scanner);
                    break;
                case 2:
                    buscarVendasDia(scanner);
                    break;
                case 3:
                    buscarVendasMes(scanner);
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 4);

        scanner.close();
    }

    private static void registrarVendas(Scanner scanner) {
        System.out.print("Informe o mês (1-12): ");
        int mes = scanner.nextInt() - 1; // Ajusta para o índice da matriz
        System.out.print("Informe o dia (1-31): ");
        int dia = scanner.nextInt() - 1; // Ajusta para o índice da matriz
        System.out.print("Informe a quantidade de vendas: ");
        int quantidade = scanner.nextInt();

        if (mes >= 0 && mes < 12 && dia >= 0 && dia < 30) {
            vendas[mes][dia] = quantidade;
            System.out.println("Vendas registradas com sucesso.");
        } else {
            System.out.println("Mês ou dia inválido.");
        }
    }

    // Funcionalidade para buscar vendas de um dia específico
    private static void buscarVendasDia(Scanner scanner) {
        System.out.print("Informe o mês (1-12): ");
        int mes = scanner.nextInt() - 1; // Ajusta para o índice da matriz
        System.out.print("Informe o dia (1-30): ");
        int dia = scanner.nextInt() - 1; // Ajusta para o índice da matriz

        if (mes >= 0 && mes < 12 && dia >= 0 && dia < 30) {
            System.out.println("Vendas no dia " + (dia + 1) + "/" + (mes + 1) + ": " + vendas[mes][dia]);
        } else {
            System.out.println("Mês ou dia inválido.");
        }
    }

    private static void buscarVendasMes(Scanner scanner) {
        System.out.print("Informe o mês (1-12): ");
        int mes = scanner.nextInt() - 1; 

        if (mes >= 0 && mes < 12) {
            int totalVendas = 0;
            for (int dia = 0; dia < 30; dia++) {
                totalVendas += vendas[mes][dia];
            }
            System.out.println("Vendas totais no mês " + (mes + 1) + ": " + totalVendas);
        } else {
            System.out.println("Mês inválido.");
        }
    }
}
