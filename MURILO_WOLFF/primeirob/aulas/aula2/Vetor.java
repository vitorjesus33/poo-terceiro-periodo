package MURILO_WOLFF.primeirob.aulas.aula2;

public class Vetor {
    public static void main(String[] args) {
        // declaração de um vetor de inteiros com 10 espaços
        int[] vetorNumeros = new int[10];

        // declaração do vetor da maneira errada para o java:
        int vetor2[] = new int[10];

        // declaração de um vetor de chars com 10 posições:
        char[] vetorDeclarado3 = new char[10];

        // fazer a inserção dentro de um vetor funciona da seguinte maneira:

        int[] numeros = {1,2,3,4,5,6,7,8,9,10};
        char[] meuNome = {'m','u','r','i','l','o'};

        // esse print dos números será um print do endereço de memória
        System.out.println(numeros);

        // esse print mostrará o primeiro numero do array:
        System.out.println(numeros[0]);

        // agora para todos os números:
        for (int numero : numeros) {
            System.out.println(numero);
        }

        // esse print mostrará o nome junto
        System.out.println(meuNome);
    }
}
