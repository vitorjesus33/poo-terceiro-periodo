package ALEX_HOFFMANN.primeirob.listas.lista2;

import java.util.Scanner;

public class CalculadoraLojaPlantasAtualizada {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Olá Dona Gabrielinha!\nQual operação deseja fazer?\n" +
                "[1] - Calcular preço Total\n[2] - Calcular Troco\n[3] - Sair");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
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
                break;
            case 2:
                System.out.println("Digite o valor pago:");
                double valorPago = sc.nextDouble();
                System.out.println("Digite o preço total:");
                double precoTotal2 = sc.nextDouble();

                double troco = valorPago - precoTotal2;
                System.out.printf("O troco é R$ %.2f/n", troco);
                break;

            case 3:
                System.out.println("Até mais Dona Gabrielinha");
                break;
            default:
                System.out.println("Quebrou a calculadora, Dona Gabrielinha!");

        }
        sc.close();
    }
}
