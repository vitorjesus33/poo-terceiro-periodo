package DIONATAN_DARIZ.primeirob.aulas.listas.listatres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Venda {
    private int quantidade;
    private double valorVenda;
    private double descontoAplicado;

    public Venda(int quantidade, double valorVenda, double descontoAplicado) {
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
        this.descontoAplicado = descontoAplicado;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public double getDescontoAplicado() {
        return descontoAplicado;
    }

    @Override
    public String toString() {
        return "Quantidade: " + quantidade + ", Valor: R$ " + valorVenda + ", Desconto: R$ " + descontoAplicado;
    }
}

class RegistroVendasDia {
    private Map<Integer, Map<Integer, Double>> registroMensal;

    public RegistroVendasDia() {
        registroMensal = new HashMap<>();
    }

    public void salvarVendas(int mes, int dia, double totalVendas) {
        if (!registroMensal.containsKey(mes)) {
            registroMensal.put(mes, new HashMap<>());
        }
        registroMensal.get(mes).put(dia, totalVendas);
        System.out.println("Total de vendas para o dia " + dia + "/" + mes + " salvo com sucesso.");
    }

    public double buscarVendas(int mes, int dia) {
        if (registroMensal.containsKey(mes) && registroMensal.get(mes).containsKey(dia)) {
            return registroMensal.get(mes).get(dia);
        } else {
            System.out.println("Nenhum registro encontrado para o dia " + dia + "/" + mes);
            return 0.0;
        }
    }
}

public class Calculadora {
    private static List<Venda> registroDeVendas = new ArrayList<>();
    private static RegistroVendasDia registroVendasDia = new RegistroVendasDia();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Visualizar Registro de Vendas");
            System.out.println("[4] - Salvar Vendas do Dia");
            System.out.println("[5] - Buscar Vendas por Dia e Mês");
            System.out.println("[6] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Digite a quantidade de plantas: ");
                int quantidade = scanner.nextInt();
                System.out.print("Digite o preço unitário da planta: ");
                double precoUnitario = scanner.nextDouble();
                double valorTotal = calcularPrecoTotal(quantidade, precoUnitario);
                System.out.println("Valor Total: R$ " + valorTotal);
                if (quantidade > 10) {
                    double desconto = valorTotal * 0.05;
                    valorTotal -= desconto;
                    System.out.println("Desconto aplicado: R$ " + desconto);
                }
                registrarVenda(quantidade, valorTotal, (quantidade > 10) ? valorTotal * 0.05 : 0);

            } else if (opcao == 2) {
                System.out.print("Digite o valor total da compra: ");
                double valorTotal = scanner.nextDouble();
                System.out.print("Digite o valor pago pelo cliente: ");
                double valorPago = scanner.nextDouble();
                calcularTroco(valorTotal, valorPago);

            } else if (opcao == 3) {
                visualizarRegistroDeVendas();

            } else if (opcao == 4) {
                int mes = obterMesValido(scanner);
                int dia = obterDiaValido(scanner);
                System.out.print("Digite o total de vendas: ");
                double totalVendas = scanner.nextDouble();
                registroVendasDia.salvarVendas(mes, dia, totalVendas);

            } else if (opcao == 5) {
                int mes = obterMesValido(scanner);
                int dia = obterDiaValido(scanner);
                double totalVendas = registroVendasDia.buscarVendas(mes, dia);
                if (totalVendas != 0.0) {
                    System.out.println("Total de vendas no dia " + dia + "/" + mes + ": R$ " + totalVendas);
                }

            } else if (opcao == 6) {
                System.out.println("Encerrando o programa...");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    // Método para obter um mês válido (1-12)
    private static int obterMesValido(Scanner scanner) {
        int mes;
        do {
            System.out.print("Digite o mês (1-12): ");
            mes = scanner.nextInt();
            if (mes < 1 || mes > 12) {
                System.out.println("Mês inválido. Por favor, insira um valor entre 1 e 12.");
            }
        } while (mes < 1 || mes > 12);
        return mes;
    }

    // Método para obter um dia válido (1-30)
    private static int obterDiaValido(Scanner scanner) {
        int dia;
        do {
            System.out.print("Digite o dia (1-30): ");
            dia = scanner.nextInt();
            if (dia < 1 || dia > 30) {
                System.out.println("Dia inválido. Por favor, insira um valor entre 1 e 30.");
            }
        } while (dia < 1 || dia > 30);
        return dia;
    }

    public static double calcularPrecoTotal(int quantidade, double precoUnitario) {
        return quantidade * precoUnitario;
    }

    public static void calcularTroco(double valorTotal, double valorPago) {
        if (valorPago < valorTotal) {
            System.out.println("Valor pago insuficiente. Faltam R$ " + (valorTotal - valorPago));
        } else {
            double troco = valorPago - valorTotal;
            System.out.println("Troco: R$ " + troco);
        }
    }

    public static void registrarVenda(int quantidade, double valorVenda, double descontoAplicado) {
        Venda venda = new Venda(quantidade, valorVenda, descontoAplicado);
        registroDeVendas.add(venda);
        System.out.println("Venda registrada: " + venda);
    }

    public static void visualizarRegistroDeVendas() {
        System.out.println("Registro de Vendas:");
        for (Venda venda : registroDeVendas) {
            System.out.println(venda);
        }
    }
}
