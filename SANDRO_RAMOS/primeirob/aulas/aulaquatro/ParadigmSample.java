package primeirob.aulas.aulaquatro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParadigmSample {

    public static void main(String[] args) {

        List<String> nomes = List.of(
                "João Fernando", "Magagnin", "Sandro Ramos");
        List<String> nomesSemEspaco = new ArrayList<>();

        for (String nome : nomes) {
            if (!nome.contains(" ")) {
                nomesSemEspaco.add(nome);
            }
        }

        System.out.println(nomesSemEspaco);

        List<String> nomesSemEspacoDois = new ArrayList<>();

        nomesSemEspacoDois = nomes.stream()
                .filter(nome -> !nome.contains(" "))
                .collect(Collectors.toList());

        System.out.println(nomesSemEspacoDois);
    }

}
