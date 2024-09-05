package VINICIUS_PASCOATO.primeirob.listas.listatres;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Calculadoratres {

    private static List<String> registrosDeVendas = new ArrayList<>();
    private static Map<String, Integer> vendasDiarias = new HashMap<>();
    private static Map<String, Integer> vendasMensais = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidade, opcao;

        do {
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Exibir Registros de Vendas");
            System.out.println("[4] - Registrar Vendas do Dia");
            System.out.println("[5] - Buscar Vendas por Dia");
            System.out.println("[6] - Buscar Vendas por Mês");
            System.out.println("[7] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcao) {
                case 1:
                    System.out.print("Digite o preço unitário da planta (em centavos): ");
                    int precoUnitario = scanner.nextInt();
                    System.out.print("Digite a quantidade de plantas: ");
                    quantidade = scanner.nextInt();

                    int precoTotal = quantidade * precoUnitario;
                    int desconto = 0;

                    if (quantidade > 10) {
                        desconto = precoTotal * 5 / 100;
                        precoTotal -= desconto;
                        System.out.printf("O preço total com desconto é: R$ %d,%02d%n", precoTotal / 100,
                                precoTotal % 100);
                    } else {
                        System.out.printf("O preço total da venda é: R$ %d,%02d%n", precoTotal / 100, precoTotal % 100);
                    }
                    String registroVenda = String.format("Quantidade: %d, Valor da Venda: R$ %d,%02d, Desconto: %d%%",
                            quantidade, precoTotal / 100, precoTotal % 100, desconto * 100 / (precoTotal + desconto));
                    registrosDeVendas.add(registroVenda);
                    System.out.println("Venda registrada com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o valor recebido pelo cliente (em centavos): ");
                    int valorRecebido = scanner.nextInt();
                    System.out.print("Digite o valor total da compra (em centavos): ");
                    int valorTotal = scanner.nextInt();

                    if (valorRecebido < valorTotal) {
                        System.out.println("O valor recebido é insuficiente para cobrir o valor da compra.");
                    } else {
                        int troco = valorRecebido - valorTotal;
                        System.out.printf("O troco a ser dado ao cliente é: R$ %d,%02d%n", troco / 100, troco % 100);
                    }
                    break;

                case 3:
                    System.out.println("Registros de Vendas:");
                    for (String venda : registrosDeVendas) {
                        System.out.println(venda);
                    }
                    break;

                case 4:
                    System.out.print("Digite a data (dia/mês) para registrar vendas (dd/MM): ");
                    String dataDia = scanner.nextLine();
                    System.out.print("Digite a quantidade total de vendas realizadas no dia: ");
                    int quantidadeVendasDia = scanner.nextInt();
                    
                    vendasDiarias.put(dataDia, vendasDiarias.getOrDefault(dataDia, 0) + quantidadeVendasDia);
                    vendasMensais.put(dataDia.substring(3), vendasMensais.getOrDefault(dataDia.substring(3), 0) + quantidadeVendasDia);
                    System.out.println("Vendas do dia registradas com sucesso!");
                    break;

                case 5:
                    System.out.print("Digite a data (dia/mês) para buscar vendas (dd/MM): ");
                    String dataBuscaDia = scanner.nextLine();
                    int vendasDia = vendasDiarias.getOrDefault(dataBuscaDia, 0);
                    System.out.printf("Total de vendas no dia %s: %d%n", dataBuscaDia, vendasDia);
                    break;

                case 6:
                    System.out.print("Digite o mês para buscar vendas (mês/ano) (MM/AAAA): ");
                    String mesBusca = scanner.nextLine();
                    int vendasMes = vendasMensais.getOrDefault(mesBusca, 0);
                    System.out.printf("Total de vendas no mês %s: %d%n", mesBusca, vendasMes);
                    break;

                case 7:
                    // Sair
                    System.out.println("Saindo. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 7);

        scanner.close();
    }
}
