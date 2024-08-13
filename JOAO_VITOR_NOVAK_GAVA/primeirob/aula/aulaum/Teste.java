package JOAO_VITOR_NOVAK_GAVA.primeirob.aula.aulaum;

import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {

        Globals globals = new Globals();

        try (Scanner leitor = new Scanner(System.in)) {
            int escolha;
            do {

                System.out.println("Menu--\n[1]Calcular Preço\n[2]Calcular Troco\n[3]Sair");
                escolha = leitor.nextInt();

                switch (escolha) {
                    case 1 -> globals.calcularPreco();
                    case 2 -> globals.calcularTroco();
                    case 3 -> System.out.println("Você saiu ;)");
                    default -> System.out.println("Opção inválida");
                }

            } while (escolha != 3);
        }
    }

}
