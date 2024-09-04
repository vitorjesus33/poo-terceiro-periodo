package primeirob.aulas.aulatres;

public class LoopMatriz {

    public static void main(String[] args) {
        int[][] matrizSample = new int[][] {
                { 20, 34 },
                { 4, 17 },
                { 18, 85 }
        };

        for (int linha = 0; linha < matrizSample.length; linha++) {
            for (int coluna = 0; coluna < matrizSample[linha].length; coluna++) {
                System.out.println(matrizSample[linha][coluna]);
            }
        }

    }
}
