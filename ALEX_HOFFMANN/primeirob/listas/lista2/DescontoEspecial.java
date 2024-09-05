package ALEX_HOFFMANN.primeirob.listas.lista2;

public class DescontoEspecial {

    public static double calcularDesconto(int quantidade, double precoUnitario) {
            if (quantidade > 10) {
                double desconto = precoUnitario * quantidade * 0.05; // 5% de desconto
                return desconto;
            } else {
                return 0; // Sem desconto
            }
        }
    }

