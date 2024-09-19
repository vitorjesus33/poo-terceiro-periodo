package GUILHERME_HENRIQUE.primeirob.listas.listatres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class  SalvandoDadosDasVendas{

    private static final int LIMITE_DESCONTO = 10;
    private static final double DESCONTO_PERCENTUAL = 0.05;
    
    static class RegistroVenda {
        int quantidade;
        double precoUnitario;
        double valorTotal;
        double descontoAplicado;
        
        RegistroVenda(int quantidade, double precoUnitario, double valorTotal, double descontoAplicado) {
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
            this.valorTotal = valorTotal;
            this.descontoAplicado = descontoAplicado;
        }
        
        @Override
        public String toString() {
            return String.format("Quantidade: %d, Preço Unitário: R$ %.2f, Valor Total: R$ %.2f, Desconto Aplicado: R$ %.2f",
                    quantidade, precoUnitario, valorTotal, descontoAplicado);
        }
    }
    
    private static List<RegistroVenda> registros = new ArrayList<>();
    private static Map<String, Double> vendasDiarias = new HashMap<>();

    public static double calcularPrecoTotal(int quantidade, double precoUnitario) {
        double valorTotal = quantidade * precoUnitario;
        if (quantidade > LIMITE_DESCONTO) {
            double desconto = valorTotal * DESCONTO_PERCENTUAL;
            valorTotal -= desconto;
            registros.add(new RegistroVenda(quantidade, precoUnitario, valorTotal, desconto));
        } else {
            registros.add(new RegistroVenda(quantidade, precoUnitario, valorTotal, 0));
        }
        return valorTotal;
    }

    public static double calcularTroco(double valorPago, double valorTotal) {
        return valorPago - valorTotal;
    }

    public static void exibirRegistros() {
        if (registros.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            System.out.println("Registros de Vendas:");
            for (RegistroVenda registro : registros) {
                System.out.println(registro);
            }
        }
    }

    public static void salvarVendasDiarias(int mes, int dia, double totalVendas) {
        String chave = mes + "-" + dia;
        vendasDiarias.put(chave, totalVendas);
        System.out.println("Vendas salvas com sucesso!");
    }

    public static Double buscarVendasDiarias(int mes, int dia) {
        String chave = mes + "-" + dia;
        return vendasDiarias.get(chave);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;
        
        do {
            System.out.println("Menu:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Exibir Registros de Vendas");
            System.out.println("[4] - Sair");
            System.out.println("[5] - Salvar Vendas Diárias");
            System.out.println("[6] - Buscar Vendas Diárias");
            System.out.print("Escolha uma opção: ");
            
            escolha = scanner.nextInt();
            
            switch (escolha) {
                case 1:
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Digite o preço unitário: ");
                    double precoUnitario = scanner.nextDouble();
                    double precoTotal = calcularPrecoTotal(quantidade, precoUnitario);
                    System.out.printf("O preço total é: R$ %.2f%n", precoTotal);
                    break;
                    
                case 2:
                    System.out.print("Digite o valor pago: ");
                    double valorPago = scanner.nextDouble();
                    System.out.print("Digite o valor total da compra: ");
                    double valorTotal = scanner.nextDouble();
                    double troco = calcularTroco(valorPago, valorTotal);
                    System.out.printf("O troco a ser dado é: R$ %.2f%n", troco);
                    break;
                    
                case 3:
                    exibirRegistros();
                    break;
                    
                case 4:
                    // Sair
                    System.out.println("Saindo...");
                    break;

                case 5:
                    System.out.print("Digite o mês (1-12): ");
                    int mes = scanner.nextInt();
                    System.out.print("Digite o dia (1-31): ");
                    int dia = scanner.nextInt();
                    System.out.print("Digite o total de vendas: ");
                    double totalVendas = scanner.nextDouble();
                    salvarVendasDiarias(mes, dia, totalVendas);
                    break;

                case 6:
                    System.out.print("Digite o mês (1-12): ");
                    mes = scanner.nextInt();
                    System.out.print("Digite o dia (1-31): ");
                    dia = scanner.nextInt();
                    Double vendas = buscarVendasDiarias(mes, dia);
                    if (vendas != null) {
                        System.out.printf("Total de vendas para %d/%d: R$ %.2f%n", mes, dia, vendas);
                    } else {
                        System.out.println("Nenhuma venda registrada para a data informada.");
                    }
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
            
        } while (escolha != 4);
        
        scanner.close();
    }
}
