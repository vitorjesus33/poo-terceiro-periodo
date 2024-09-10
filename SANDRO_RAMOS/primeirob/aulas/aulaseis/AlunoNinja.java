package primeirob.aulas.aulaseis;

public class AlunoNinja extends Ninja {

    String nomeTime;

    String nomeProfessor;

    @Override
    public void apresentarse() {
        System.out.println("Sou o aluno ninja"
                + name + ", meu professor é o " + nomeProfessor
                + " e sou do time " + nomeTime);
    }

    @Override
    public void realizarJutso() {
        System.out.println("Realizando jutso " + nomeJutso + "!!");
    }
}
