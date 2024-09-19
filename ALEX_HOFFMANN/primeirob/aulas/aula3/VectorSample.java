package ALEX_HOFFMANN.primeirob.aulas.aula3;

public class VectorSample {
    public static void main(String[] args) {
        String[] vetorzinStr = new String[10];
        int index = 0;

        while (index < vetorzinStr.length) {
            vetorzinStr[index] = "Pedro";
            System.out.println(vetorzinStr[index]);
            index++;
        }
        System.out.println(vetorzinStr[9]);
    }
}
