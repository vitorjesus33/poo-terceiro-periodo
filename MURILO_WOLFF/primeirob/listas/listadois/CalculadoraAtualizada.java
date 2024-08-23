package MURILO_WOLFF.primeirob.listas.listadois;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculadoraAtualizada {
    private static ArrayList<String> registroVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int escolha;

        do {
            System.out.println("-- Menu --\n[1] - Calcular preço geral\n[2] - Calcular Troco\n[3] - Verificar vendas\n[4] - Sair");
            escolha = leitor.nextInt();

            switch (escolha) {
                case 1:
                    calculoPrecoGeral(leitor);
                    break;
                case 2:
                    calcularTroco(leitor);
                    break;
                case 3:
                    verificarVendas(leitor);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 4);

        leitor.close();
    }

    static void logVendas(int qtdPlantas, double precoUnitario, double valorTotal, boolean descontoAplicado) {
        String registro = "Quantidade: " + qtdPlantas + ", Preço Unitário: R$" + precoUnitario +
                ", Valor Total: R$" + valorTotal + ", Desconto Aplicado: " + (descontoAplicado ? "Sim" : "Não");
        registroVendas.add(registro);
    }

    static void calculoPrecoGeral(Scanner leitor) {
        System.out.println("Insira a quantidade de plantas compradas: ");
        int qtdPlantas = leitor.nextInt();

        System.out.println("Insira o preço unitário das plantas: ");
        double preco = leitor.nextDouble();

        double valorTotal = qtdPlantas * preco;
        boolean descontoAplicado = false;

        if (qtdPlantas > 10) {
            valorTotal *= 0.95;
            descontoAplicado = true;
        }

        System.out.println("Preço total das plantas compradas: R$" + valorTotal);
        logVendas(qtdPlantas, preco, valorTotal, descontoAplicado);
    }

    static void calcularTroco(Scanner leitor) {
        System.out.println("Valor recebido: ");
        double dinValor = leitor.nextDouble();

        System.out.println("Valor total das plantas compradas: ");
        double totalCompra = leitor.nextDouble();

        System.out.println("Valor do troco: R$" + (dinValor - totalCompra));
    }

    static void verificarVendas(Scanner leitor) {
        int tamanhoPagina = 5;
        int paginaAtual = 0;

        while (paginaAtual * tamanhoPagina < registroVendas.size()) {
            int inicio = paginaAtual * tamanhoPagina;
            int fim = Math.min(inicio + tamanhoPagina, registroVendas.size());

            System.out.println("\n-- Vendas Página " + (paginaAtual + 1) + " --");
            for (int i = inicio; i < fim; i++) {
                System.out.println(registroVendas.get(i));
            }

            System.out.println("\n[1] Próxima Página | [2] Página Anterior | [3] Sair");
            int escolha = leitor.nextInt();

            if (escolha == 1) {
                if ((paginaAtual + 1) * tamanhoPagina < registroVendas.size()) {
                    paginaAtual++;
                } else {
                    System.out.println("Você já está na última página.");
                }
            } else if (escolha == 2) {
                if (paginaAtual > 0) {
                    paginaAtual--;
                } else {
                    System.out.println("Você já está na primeira página.");
                }
            } else if (escolha == 3) {
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
