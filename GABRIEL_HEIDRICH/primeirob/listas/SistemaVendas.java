import java.util.ArrayList;
import java.util.Scanner;

public class SistemaVendas {

    static class Venda {
        int quantidade;
        double precoUnitario;
        double valorTotal;
        double descontoAplicado;

        Venda(int quantidade, double precoUnitario, double valorTotal, double descontoAplicado) {
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
            this.valorTotal = valorTotal;
            this.descontoAplicado = descontoAplicado;
        }

        @Override
        public String toString() {
            return String.format("Quantidade: %d, Preço Unitário: R$%.2f, Valor Total: R$%.2f, Desconto Aplicado: R$%.2f",
                    quantidade, precoUnitario, valorTotal, descontoAplicado);
        }
    }

    private static final ArrayList<Venda> historicoVendas = new ArrayList<>();

    private static double calcularValorComDesconto(int quantidade, double precoUnitario) {
        double valorTotal = quantidade * precoUnitario;
        if (quantidade > 10) {
            valorTotal *= 0.95; 
        }
        return valorTotal;
    }

    private static void registrarVenda(int quantidade, double precoUnitario, double valorTotal, double descontoAplicado) {
        Venda venda = new Venda(quantidade, precoUnitario, valorTotal, descontoAplicado);
        historicoVendas.add(venda);
    }

    private static void exibirHistoricoVendas() {
        if (historicoVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            System.out.println("\nHistórico de Vendas:");
            for (Venda venda : historicoVendas) {
                System.out.println(venda);
            }
        }
    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Registrar venda");
            System.out.println("2. Exibir histórico de vendas");
            System.out.println("3. Sair");

            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Digite a quantidade de plantas: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Digite o preço unitário da planta: ");
                    double precoUnitario = scanner.nextDouble();

                    double valorTotal = calcularValorComDesconto(quantidade, precoUnitario);
                    double descontoAplicado = quantidade * precoUnitario - valorTotal;

                    registrarVenda(quantidade, precoUnitario, valorTotal, descontoAplicado);
                    System.out.printf("Venda registrada! Valor total a pagar: R$%.2f%n", valorTotal);
                    break;

                case 2:
                    exibirHistoricoVendas();
                    break;

                case 3:
                    System.out.println("Saindo do sistema.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida, por favor, escolha uma opção válida.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
