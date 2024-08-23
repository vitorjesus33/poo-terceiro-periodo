package MURILO_WOLFF.primeirob.listas.listaum;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int escolha;

        do {
            System.out.println("-- Menu --\n[1] - Calcular preço geral\n[2] - Calcular Troco\n[3] - Sair");
            escolha = leitor.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Insira a quantidade de plantas compradas: ");
                    int qtdPlantas = leitor.nextInt();
                    System.out.println("Preço da planta: ");
                    double preco = leitor.nextDouble();
                    System.out.println("Preço total das plantas compradas: R$" + (qtdPlantas * preco));
                    break;
                case 2:
                    System.out.println("Valor recebido: ");
                    double dinValor = leitor.nextDouble();
                    System.out.println("Valor total das plantas compradas: ");
                    double totalCompra = leitor.nextDouble();
                    System.out.println("Valor do troco: R$" + (dinValor - totalCompra));
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 3);

        leitor.close();
    }
}