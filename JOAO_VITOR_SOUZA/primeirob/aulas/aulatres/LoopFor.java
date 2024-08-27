package JOAO_VITOR_SOUZA.primeirob.aulas.aulatres;

public class LoopFor {

    public static void main(String[] args) {
        String[] frutas = new String[] { "🍊", "🍐", "🍇", "🍇" };
        int[] test = new int[] { 23, 44 };

        // for (int i = 0; i < frutas.length; i++) {
        //     if (frutas[i] == "🍇") {
        //         System.out.println("Não quero executar resto");

        //         continue;
        //     }

        //     if (frutas[i] == "🍐") {
        //         System.out.println("Encerre a iteração");
        //         break;
        //     }

        //     System.out.print(frutas[i]);
        // }

        for (String str : frutas) {
            System.out.println(str);
        }

        for (int i : test) {
            System.out.println(i);
        }

        System.out.println("Finalizou...");
    }

}

