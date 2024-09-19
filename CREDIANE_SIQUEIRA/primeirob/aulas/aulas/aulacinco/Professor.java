package CREDIANE_SIQUEIRA.primeirob.aulas.aulas.aulacinco;

public class Professor {
    String nome;
    String materia;
    boolean genteBoa;
    String qualificacao;

    public void apresentarse() {
        String msg = ("Ola, meu nome e ")
            .concat(nome)
            .concat("e leciono")
            .concat(materia);
        //    .concat("e");

        System.out.println(msg);
    }
}
