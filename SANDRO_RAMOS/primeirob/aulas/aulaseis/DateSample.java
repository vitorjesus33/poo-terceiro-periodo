package primeirob.aulas.aulaseis;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSample {

    public static void main(String[] args) {

        Long diaEmMs = 86400000l;
        Date dataEpochMaisUmDia = new Date(diaEmMs);
        Date agora = new Date();
        Long msAtual = agora.getTime();

        Date amanha = new Date(msAtual + (diaEmMs * 3));

        Date dataAleatoria = new Date(124, 9, 10);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

        System.out.println(dataEpochMaisUmDia);
        System.out.println(agora);
        System.out.println(amanha);
        System.out.println(dataAleatoria);

        System.out.println(dateFormat.format(dataAleatoria));
    }

}
