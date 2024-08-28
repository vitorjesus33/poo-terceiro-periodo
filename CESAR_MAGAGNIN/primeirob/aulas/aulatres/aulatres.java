package CESAR_MAGAGNIN.primeirob.aulas.aulatres;

public class aulatres {
    public static void main (String [] args) {
        int[][] matrizUm = {{31,27,4},{44,32,95},{9,16,56}};
        int[][] matrizDois = {{10,88,12},{38,32,73},{14,21,52}};
        for (int i = 0; i < matrizUm.length; i ++) {
            for (int j = 0; j < matrizDois.length; j ++){
                double soma = matrizUm [i][j] + matrizDois [i][j];
                System.out.println(soma);

            }
        }
    }

}
// fazer a soma das duas matrizes e criar uma terceira matriz com o resulta da soma das duas matrizes