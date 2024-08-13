package JOAO_VITOR_NOVAK_GAVA.primeirob.aula.aulaum;

import java.util.Scanner;

public class Globals {
    Scanner leitor = new Scanner(System.in);

    protected void calcularPreco() {
        System.out.print("Digite a quantidade: ");
        int quantidade = leitor.nextInt();
        System.out.print("Digite o preço: ");
        float preco = leitor.nextFloat();
        float total = quantidade * preco;
        System.out.println("Total: " + total);
    }

    protected void calcularTroco() {
        System.out.print("Digite o total: ");
        float total = leitor.nextFloat();
        System.out.print("Digite o valor recebido: ");
        float valorRecebido = leitor.nextFloat();
        float troco = total - valorRecebido;
        System.out.println("Troco: " + troco);
    }

}
