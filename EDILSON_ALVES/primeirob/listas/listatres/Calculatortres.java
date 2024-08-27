package EDILSON_ALVES.primeirob.listas.listatres;


import java.util.Scanner;

public class Calculatortres {

    static class Venda {
        int quantidade;
        int precoUnitario;
        int valorTotal;
        int desconto;
        int dia;
        int mes;

        public Venda(int quantidade, int precoUnitario, int valorTotal, int desconto, int dia, int mes) {
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
            this.valorTotal = valorTotal;
            this.desconto = desconto;
            this.dia = dia;
            this.mes = mes;
        }

        public String toString() {
            return "Quantidade: " + quantidade +", Preço Unitário: " + precoUnitario +", Valor Total: " + valorTotal +", Desconto: " + desconto + ", Data: " + dia + "/" + mes;     }
    }

    public static void main(String[] args) {
        final int MAX_VENDAS = 100;
        Venda[] vendas = new Venda[MAX_VENDAS];
        int numVendas = 0;

        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("[1] Calcular o preço total | [2] Calcular o troco | [3] Consultar vendas por dia | [4] Consultar vendas por mês | [0] Sair");
            opcao = scan.nextInt();

            if (opcao == 0) {
                System.out.println("Saindo");
                break;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor do produto:");
                    int valorUnitario = scan.nextInt();

                    System.out.println("Digite quantas unidades deste produto você deseja:");
                    int quantidade = scan.nextInt();

                    int valorTotal = valorUnitario * quantidade;
                    int desconto = 0;

                    if (quantidade > 10) {
                        desconto = (valorTotal * 5) / 100;
                        valorTotal -= desconto;
                    }

                    System.out.println("O valor total com desconto é: " + valorTotal +
                                       " (Desconto: " + desconto + ")");

                    System.out.println("Digite o dia da venda:");
                    int dia = scan.nextInt();
                    System.out.println("Digite o mês da venda:");
                    int mes = scan.nextInt();

                    if (numVendas < MAX_VENDAS) {
                        vendas[numVendas++] = new Venda(quantidade, valorUnitario, valorTotal, desconto, dia, mes);
                    } else {
                        System.out.println("Espaço para mais vendas está cheio.");
                    }
                    break;

                case 2:
                    System.out.println("Digite o valor que o cliente deu:");
                    int valorPago = scan.nextInt();
                    System.out.println("Digite o valor da compra:");
                    int valorCompra = scan.nextInt();

                    int troco = valorPago - valorCompra;
                    System.out.println("O troco é: " + troco);
                    break;

                case 3:
                    System.out.println("Digite o dia da consulta:");
                    int diaConsulta = scan.nextInt();
                    System.out.println("Digite o mês da consulta:");
                    int mesConsulta = scan.nextInt();

                    int totalVendasDia = 0;
                    for (int i = 0; i < numVendas; i++) {
                        if (vendas[i].dia == diaConsulta && vendas[i].mes == mesConsulta) {
                            totalVendasDia += vendas[i].valorTotal;
                        }
                    }

                    System.out.println("Total de vendas no dia " + diaConsulta + "/" + mesConsulta + ": " + totalVendasDia);
                    break;

                case 4:
                    System.out.println("Digite o mês da consulta:");
                    int mesConsultaMes = scan.nextInt();

                    int totalVendasMes = 0;
                    for (int i = 0; i < numVendas; i++) {
                        if (vendas[i].mes == mesConsultaMes) {
                            totalVendasMes += vendas[i].valorTotal;
                        }
                    }

                    System.out.println("Total de vendas no mês " + mesConsultaMes + ": " + totalVendasMes);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scan.close();

        System.out.println("Registro de Vendas:");
        for (int i = 0; i < numVendas; i++) {
            System.out.println("Venda " + (i + 1) + ": " + vendas[i]);
        }
    }
}
