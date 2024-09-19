package JOAO_VITOR_NOVAK_GAVA.primeirob.listaTres.main;

import JOAO_VITOR_NOVAK_GAVA.primeirob.listaTres.CalculadoraPreco;
import JOAO_VITOR_NOVAK_GAVA.primeirob.listaTres.FiltroData;
import JOAO_VITOR_NOVAK_GAVA.primeirob.listaTres.Historico;
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {

        try (Scanner leitor = new Scanner(System.in)) {
            int escolha;
            do {
                System.out.println(
                        "Menu--\n[1]Registrar venda \n[2]Calcular Troco\n[3]Histórico\n[4]Filtrar por Ano\n[5]Filtrar por Mês\n[6]Filtrar por Dia\n[0]Sair");
                escolha = leitor.nextInt();

                switch (escolha) {
                    case 1 -> CalculadoraPreco.calcularPreco();
                    case 2 -> CalculadoraPreco.calcularTroco();
                    case 3 -> Historico.exibirHistorico();
                    case 4 -> FiltroData.filtrarPorAno(Historico.getRegistros());
                    case 5 -> FiltroData.filtrarPorMes(Historico.getRegistros());
                    case 6 -> FiltroData.filtrarPorDia(Historico.getRegistros());
                    case 0 -> System.out.println("Você saiu ;)");
                    default -> System.out.println("Opção inválida");
                }

            } while (escolha != 0);
        }
    }
}