package JACY_CORDEIRO.primeirob.listas.listaum

import java.util.HashMap;
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Operacoes n = new Operacoes();

        System.out.println("Escolha uma operação: ");
        System.out.println("1. Soma");
        System.out.println("2. Subtração");
        System.out.println("3. Multiplicação");
        System.out.println("4. Divisão");
        
        int operacao = scan.nextInt();

        System.out.println("Digite o primeiro número: ");
        double x = scan.nextDouble();

        System.out.println("Digite o segundo número: ");
        double y = scan.nextDouble();

        switch (operacao) {
            case 1:
                imprimeCalculadora(operacao, n.soma(x, y), x, y);
                break;
            case 2:
                imprimeCalculadora(operacao, n.subtracao(x, y), x, y);
                break;
            case 3:
                imprimeCalculadora(operacao, n.multiplicacao(x, y), x, y);
                break;
            case 4:
                imprimeCalculadora(operacao, n.divisao(x, y), x, y);
                break;
            default:
                System.out.println("Operação inválida!");
        }

        scan.close();
    }

    static void imprimeCalculadora(int operacao, double resultado, double x, double y) {
        HashMap<Integer, String> mapOperacao = new HashMap<>();
        mapOperacao.put(1, "somado");
        mapOperacao.put(2, "subtraído");
        mapOperacao.put(3, "multiplicado");
        mapOperacao.put(4, "dividido");

        System.out.println("\nO resultado de " + x + " " + mapOperacao.get(operacao) + " por " + y + " é igual a " + resultado + "\n");
    }
}

class Operacoes {
    public double soma(double a, double b) {
        return a + b;
    }

    public double subtracao(double a, double b) {
        return a - b;
    }

    public double multiplicacao(double a, double b) {
        return a * b;
    }

    public double divisao(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Divisão por zero não é permitida!");
            return 0;
        }
    }
}
