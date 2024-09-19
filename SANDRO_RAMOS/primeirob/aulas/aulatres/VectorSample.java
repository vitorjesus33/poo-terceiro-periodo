package primeirob.aulas.aulatres;

public class VectorSample {

    public static void main(String[] args) {
        // Declaraçao
        int[][] matrizDeclarada;
        // System.out.println(matrizDeclarada);
        int[][] matrizUm = new int[4][6];
        int[][] matrizDois = new int[][] { { 24, 39 }, { 12, 26 } };

        try {
            System.out.println(matrizDois[1][1]);
            System.out.println(matrizDois[2][2]);
        } catch (Exception e) {
            System.out.println("Deu ruim!" + e.getMessage());
        }

    }

}
