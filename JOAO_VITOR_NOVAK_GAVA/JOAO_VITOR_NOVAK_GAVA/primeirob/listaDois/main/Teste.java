package JOAO_VITOR_NOVAK_GAVA.primeirob.listaDois.main;

import JOAO_VITOR_NOVAK_GAVA.primeirob.listaDois.CalculadoraPreco;
import JOAO_VITOR_NOVAK_GAVA.primeirob.listaDois.Historico;
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {

        try (Scanner leitor = new Scanner(System.in)) {
            int escolha;
            do {

                System.out.println("Menu--\n[1]Calcular Preço\n[2]Calcular Troco\n[3]Histórico\n[0]Sair");
                escolha = leitor.nextInt();

                switch (escolha) {
                    case 1 -> CalculadoraPreco.calcularPreco();
                    case 2 -> CalculadoraPreco.calcularTroco();
                    case 3 -> Historico.exibirHistorico();
                    case 0 -> System.out.println("Você saiu ;)");
                    default -> System.out.println("Opção inválida");
                }

            } while (escolha != 0);
        }
    }

}
