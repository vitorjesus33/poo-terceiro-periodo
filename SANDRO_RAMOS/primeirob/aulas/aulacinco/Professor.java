package primeirob.aulas.aulacinco;

public class Professor {

    String nome;

    String materia;

    Arma arma;

    boolean genteBoa;

    String qualificacao;

    public void apresentarse() {
        String msg = "Olá meu nome é "
                .concat(nome)
                .concat(" e leciono ")
                .concat(materia)
                .concat(" e ")
                .concat(genteBoa ? "sou" : "não sou")
                .concat(" gente boa.");

        System.out.println(msg);
    }

}
