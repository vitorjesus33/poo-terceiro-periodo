package JOAO_VITOR_NOVAK_GAVA.primeirob.listaTres;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class FiltroData {

    static Scanner leitor = new Scanner(System.in);

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void filtrarPorAno(List<Registro> registros) {
        System.out.print("Digite o ano: ");
        int ano = leitor.nextInt();
        System.out.println("Registros do ano " + ano + ":");
        registros.stream()
                .filter(registro -> registro.getData().getYear() == ano)
                .forEach(registro -> exibirRegistro(registro));
    }

    public static void filtrarPorMes(List<Registro> registros) {
        System.out.print("Digite o ano: ");
        int ano = leitor.nextInt();
        System.out.print("Digite o mês: ");
        int mes = leitor.nextInt();
        System.out.println("Registros do mês " + mes + "/" + ano + ":");
        registros.stream()
                .filter(registro -> registro.getData().getYear() == ano && registro.getData().getMonthValue() == mes)
                .forEach(registro -> exibirRegistro(registro));
    }

    public static void filtrarPorDia(List<Registro> registros) {
        System.out.print("Digite o ano: ");
        int ano = leitor.nextInt();
        System.out.print("Digite o mês: ");
        int mes = leitor.nextInt();
        System.out.print("Digite o dia: ");
        int dia = leitor.nextInt();
        System.out.println("Registros do dia " + dia + "/" + mes + "/" + ano + ":");
        registros.stream()
                .filter(registro -> registro.getData().getYear() == ano &&
                        registro.getData().getMonthValue() == mes &&
                        registro.getData().getDayOfMonth() == dia)
                .forEach(registro -> exibirRegistro(registro));
    }

    private static void exibirRegistro(Registro registro) {
        System.out.println("Data: " + registro.getData().format(formatter) +
                ", Quantidade: " + registro.getQuantidade() +
                ", Total: R$ " + registro.getTotal() +
                ", Desconto: " + (registro.isDesconto() ? "Sim" : "Não"));
    }
}
