package JOAO_VITOR_SOUZA.primeirob.listas.listatres;

import java.util.Scanner;

class SistemaVendalistatres {
    private static final int MESES = 12;
    private static final int DIAS = 30;
    private static double[][] vendasPorDia = new double[MESES][DIAS];
    private static RegistroVenda[] registros = new RegistroVenda[10];
    private static int contador = 0;

    // Adiciona um novo registro ao vetor, verificando se há espaço
    private static void adicionarRegistro(RegistroVenda registro) {
        if (contador < registros.length) {
            registros[contador++] = registro;
        } else {
            System.out.println("Não é possível adicionar mais registros. O vetor está cheio.");
        }
    }

    // Calcula o valor total com possível desconto e adiciona o registro
    public static double calcularValorComDesconto(int quantidade, double precoUnitario) {
        double valorTotal = quantidade * precoUnitario;
        double desconto = 0;
        if (quantidade > 10) {
            desconto = valorTotal * 0.05;
            valorTotal -= desconto;
        }
        adicionarRegistro(new RegistroVenda(quantidade, valorTotal, desconto));
        return valorTotal;
    }

    // Exibe todos os registros de vendas armazenados no vetor
    public static void mostrarRegistros() {
        if (contador == 0) {
            System.out.println("Nenhum registro de venda encontrado.");
            return;
        }
        for (int i = 0; i < contador; i++) {
            System.out.println(registros[i]);
        }
    }

    // Salva a quantidade de vendas totais de um dia
    public static void salvarVendasDia(int mes, int dia, double quantidade) {
        if (mes < 1 || mes > MESES || dia < 1 || dia > DIAS) {
            System.out.println("Mês ou dia inválido.");
            return;
        }
        vendasPorDia[mes - 1][dia - 1] = quantidade;
        System.out.println("Quantidade de vendas salva com sucesso.");
    }

    // Busca a quantidade total de vendas pelo mês e dia
    public static void buscarVendasDia(int mes, int dia) {
        if (mes < 1 || mes > MESES || dia < 1 || dia > DIAS) {
            System.out.println("Mês ou dia inválido.");
            return;
        }
        double quantidade = vendasPorDia[mes - 1][dia - 1];
        System.out.println("Quantidade de vendas no mês " + mes + " e dia " + dia + ": " + quantidade);
    }

    // Exibe o menu e executa a ação selecionada
    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        try {
            do {
                // Exibe o menu
                System.out.println("\nMenu:");
                System.out.println("1. Realizar Venda");
                System.out.println("2. Mostrar Registros de Vendas");
                System.out.println("3. Salvar Vendas de um Dia");
                System.out.println("4. Buscar Vendas de um Dia");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        realizarVenda(scanner);
                        break;
                    case 2:
                        mostrarRegistros();
                        break;
                    case 3:
                        salvarVendasDia(scanner);
                        break;
                    case 4:
                        buscarVendasDia(scanner);
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 5);
        } finally {
            scanner.close();  // Garante que o scanner seja fechado corretamente
        }
    }

    private static void realizarVenda(Scanner scanner) {
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: R$");
        double precoUnitario = scanner.nextDouble();
        double valorFinal = calcularValorComDesconto(quantidade, precoUnitario);
        System.out.println("Valor final da compra: R$" + String.format("%.2f", valorFinal));
    }

    private static void salvarVendasDia(Scanner scanner) {
        System.out.print("Digite o mês (1 a 12): ");
        int mes = scanner.nextInt();
        System.out.print("Digite o dia (1 a 30): ");
        int dia = scanner.nextInt();
        System.out.print("Digite a quantidade de vendas totais: ");
        double quantidade = scanner.nextDouble();
        salvarVendasDia(mes, dia, quantidade);
    }

    private static void buscarVendasDia(Scanner scanner) {
        System.out.print("Digite o mês (1 a 12): ");
        int mes = scanner.nextInt();
        System.out.print("Digite o dia (1 a 30): ");
        int dia = scanner.nextInt();
        buscarVendasDia(mes, dia);
    }

    public static void main(String[] args) {
        exibirMenu();
    }
}

class RegistroVenda {
    int quantidade;
    double valorVenda;
    double descontoAplicado;

    RegistroVenda(int quantidade, double valorVenda, double descontoAplicado) {
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
        this.descontoAplicado = descontoAplicado;
    }

    @Override
    public String toString() {
        return String.format("Quantidade: %d, Valor Venda: R$ %.2f, Desconto Aplicado: R$ %.2f",
                             quantidade, valorVenda, descontoAplicado);
    }
}
