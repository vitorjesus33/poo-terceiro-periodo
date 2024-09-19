package primeirob.aulas.aulaseis;

import java.util.ArrayList;
import java.util.List;

public class AppZoo {
    
    public static void main(String[] args) {

        List<Ave> passaros = new ArrayList<>();

        BemTiVi passaroUm = new BemTiVi();
        Canario passaroDois = new Canario();
        Gaviao passaroTres = new Gaviao();

        passaroUm.nome = "Roberto";
        passaroUm.cor = "Amarelo";

        passaroDois.nome = "Cleber";
        passaroDois.cor = "Branco";

        passaroTres.nome = "Rafaela";
        passaroTres.cor = "Azul";

        passaroUm.voar();
        passaroDois.voar();
        passaroTres.voar();

        passaros.add(passaroUm);
        passaros.add(passaroDois);
        passaros.add(passaroTres);
    }

}
