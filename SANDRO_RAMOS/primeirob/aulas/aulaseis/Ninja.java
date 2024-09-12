package primeirob.aulas.aulaseis;

public abstract class Ninja {

    String name;

    int idade;

    String aldeia;

    String cla;

    String equipamento;

    String nomeJutso;

    public void apresentarse() {
        System.out.println("Olá meu nome é " + name + " da aldeia da " + aldeia);
    }

    public void realizarJutso() {
        System.out.println("Realizando jutso " + nomeJutso + "!!");
    }

    public abstract void realizarInvocacao();

}
