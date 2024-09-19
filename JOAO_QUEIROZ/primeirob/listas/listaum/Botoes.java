package primeirob.listas.listaum;

import java.util.Scanner;

public class Botoes {
    static Scanner botao = new Scanner(System.in);
    
    protected static double Calcularpreco() {

        System.out.println("Informe a quantidade da planta");
        int quantidade = botao.nextInt();
        
        System.out.println("Informe o valor da planta");
        double valor = botao.nextDouble();

        System.out.println("Preço total: ");     

        return quantidade * valor;
    }
    protected static double Troco() {

        System.out.println("Valor pago:");
        double pago = botao.nextDouble();

        double valorCompra = Calcularpreco();
        
        return valorCompra - pago;
    }

}
