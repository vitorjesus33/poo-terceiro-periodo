package JACY_CORDEIRO.primeirob.aulatres;

public class ManipulacaoMatrizes {
    public static void main(String[] args) {
        // Criando duas matrizes
        int[][] matriz1 = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };

        int[][] matriz2 = {
            {5, 10, 15, 20, 25},
            {30, 35, 40, 45, 50},
            {55, 60, 65, 70, 75},
            {80, 85, 90, 95, 100},
            {105, 110, 115, 120, 125}
        };

        // Print do elemento g5 da matriz 1 (g5 = 15) e do valor 14 na matriz 2
        System.out.println("Elemento g5 da Matriz 1: " + matriz1[2][4]);  // g5 = 15 (posição [2][4])
        System.out.println("Elemento de valor 14 na Matriz 2: " + matriz2[2][2]);  // 14 (posição [2][2])

        // Somando a matriz 1 à matriz 2
        int[][] matriz3 = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz3[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        // Multiplicando a matriz 2 por 4 (multiplicação escalar)
        int[][] matrizMultiplicada = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrizMultiplicada[i][j] = matriz2[i][j] * 4;
            }
        }

        // Print dos valores da nova matriz multiplicada
        System.out.println("Valores da Matriz Multiplicada por 4:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrizMultiplicada[i][j] + " ");
            }
            System.out.println();
        }
    }
}

