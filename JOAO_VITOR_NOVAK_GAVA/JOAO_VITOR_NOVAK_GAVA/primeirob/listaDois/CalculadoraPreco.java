package JOAO_VITOR_NOVAK_GAVA.primeirob.listaDois;

import java.util.Scanner;

public class CalculadoraPreco {
    private static final Historico historico = new Historico("historico.csv");
    private static final Scanner leitor = new Scanner(System.in);

    public static void calcularPreco() {
        System.out.print("Digite a quantidade: ");
        int quantidade = leitor.nextInt();
        System.out.print("Digite o preço: ");
        float preco = leitor.nextFloat();
        float total;
        boolean desconto;

        if (quantidade >= 10) {
            total = quantidade * preco * 0.95f; // Aplicando desconto de 5%
            desconto = true;
            System.out.println("Você recebeu um desconto ;)");
        } else {
            total = quantidade * preco;
            desconto = false;
        }

        // Exibir o total
        System.out.println("Total: R$ " + total);

        // Criar um novo registro e adicioná-lo ao histórico
        Registro registro = new Registro(quantidade, total, desconto);
        historico.adicionarRegistro(registro);
    }

    public static void calcularTroco() {
        System.out.print("Digite o valor pago: ");
        float valorPago = leitor.nextFloat();
        System.out.print("Digite o valor total: ");
        float valorTotal = leitor.nextFloat();

        if (valorPago >= valorTotal) {
            float troco = valorPago - valorTotal;
            System.out.println("Troco: R$ " + troco);
        } else {
            System.out.println("O valor pago é menor que o valor total.");
        }
    }
}
