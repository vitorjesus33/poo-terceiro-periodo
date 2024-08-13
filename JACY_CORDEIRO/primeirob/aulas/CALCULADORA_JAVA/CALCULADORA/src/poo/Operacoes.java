package poo;

public class Operacoes {
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
