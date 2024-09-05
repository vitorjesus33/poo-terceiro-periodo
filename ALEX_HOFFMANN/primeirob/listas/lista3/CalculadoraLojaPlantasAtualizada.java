package ALEX_HOFFMANN.primeirob.listas.lista3;

import ALEX_HOFFMANN.primeirob.listas.lista2.DescontoEspecial;
import ALEX_HOFFMANN.primeirob.listas.lista2.RegistroDeVendas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculadoraLojaPlantasAtualizada {
    private static Map<String, Double> vendasDiarias = new HashMap<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Olá Dona Gabrielinha!\nQual operação deseja fazer?\n" +
                    "[1] - Calcular preço Total\n" +
                    "[2] - Calcular Troco\n" +
                    "[3] - Registrar vendas do dia\n" +
                    "[4] - Consultar vendas por mês e dia\n" +
                    "[5] - Sair");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(sc);
                    break;
                case 2:
                    calcularTroco(sc);
                    break;
                case 3:
                    registrarVendasDoDia(sc);
                    break;
                case 4:
                    consultarVendas(sc);
                    break;
                case 5:
                    System.out.println("Até mais Dona Gabrielinha");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private static void calcularPrecoTotal(Scanner sc) {
        System.out.println("Digite o preço unitário da planta");
        double precoUnitario = sc.nextDouble();

        System.out.println("Digite a quantidade de plantas:");
        int quantidade = sc.nextInt();

        double precoTotal = precoUnitario * quantidade;
        double desconto = DescontoEspecial.calcularDesconto(quantidade, precoUnitario);
        precoTotal -= desconto; // Aplica o desconto

        System.out.printf("O preço total é R$ %.2f\n", precoTotal);

        // Registra a venda
        RegistroDeVendas venda = new RegistroDeVendas(quantidade, precoTotal, desconto);
    }

    private static void calcularTroco(Scanner sc) {
        System.out.println("Digite o valor pago:");
        double valorPago = sc.nextDouble();
        System.out.println("Digite o preço total:");
        double precoTotal = sc.nextDouble();

        double troco = valorPago - precoTotal;
        System.out.printf("O troco é R$ %.2f\n", troco);
    }

    private static void registrarVendasDoDia(Scanner sc) {
        System.out.println("Digite o mês (número):");
        int mes = sc.nextInt();
        System.out.println("Digite o dia:");
        int dia = sc.nextInt();
        System.out.println("Digite o total de vendas do dia:");
        double totalVendas = sc.nextDouble();

        String chave = mes + "-" + dia;
        vendasDiarias.put(chave, totalVendas);

        System.out.println("Vendas registradas com sucesso para o dia " + dia + "/" + mes);
    }

    private static void consultarVendas(Scanner sc) {
        System.out.println("Digite o mês (número):");
        int mes = sc.nextInt();
        System.out.println("Digite o dia:");
        int dia = sc.nextInt();

        String chave = mes + "-" + dia;
        if (vendasDiarias.containsKey(chave)) {
            double totalVendas = vendasDiarias.get(chave);
            System.out.printf("Total de vendas para o dia %d/%d: R$ %.2f\n", dia, mes, totalVendas);
        } else {
            System.out.println("Nenhuma venda registrada para o dia " + dia + "/" + mes);
        }
    }
}
