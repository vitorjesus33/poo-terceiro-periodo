package JOAO_VITOR_SOUZA.primeirob.aulas.aulatres;

public class Loops {

    public static void main(String[] args) {

        String[] vetorzinStr = new String[10];
        int index = 0;
        System.out.println(vetorzinStr.length);

        while (index < vetorzinStr.length) {
            vetorzinStr[index] = "Sandrolax-" + index;

            index++;
        }
        
        System.out.println(vetorzinStr);
        index = 0;
        
        do {
            vetorzinStr[index] = "Do-While-" + index;
            
            index++;
        } while (index < vetorzinStr.length);

        System.out.println(vetorzinStr);

    }

}