package EDILSON_ALVES.primeirob.aulas.aulaquatro;

import java.util.ArrayList;
import java.util.List;

public class ParadigmaSample {
    public static void main(String [] args){
        List<String> nomes = List.of(
            "joao Fenando", "magagnin", "Sandro RAMOS"
        );
        List<String> nomesSemEspaco = new ArrayList();
        for (String nome: nomes){
            if(!nome.contains(" ")){
                nomesSemEspaco.add(nome);
            }
        }
        System.out.println(nomesSemEspaco);
    
    List<String> nomeSemespacoDois = new ArrayList<>();

    nomeSemespacoDois = nomes.stream()
    .filter(nome -> !nome.contains(" "))
    .toList();

    System.out.println(nomeSemespacoDois);

    }
}