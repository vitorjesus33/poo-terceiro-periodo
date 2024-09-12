package primeirob.aulas.aulaseis;

public class Main {
    
    public static void main(String[] args) {
        
        AlunoNinja alunoNinja = new AlunoNinja();

        alunoNinja.name = "Boruto";
        alunoNinja.aldeia = "Folha";
        alunoNinja.cla = "Uzumaki";
        alunoNinja.idade = 12;
        alunoNinja.nomeJutso = "Clone das sombras";

        alunoNinja.nomeTime = "Time Konohamaru";
        alunoNinja.nomeProfessor = "Konohamaru Sarutobi";
        
        Ninja ninjaDois = new AlunoNinja();

        ninjaDois.name = "Sasuke";
        ninjaDois.aldeia = "Folha";
        ninjaDois.cla = "Uchiha";
        ninjaDois.idade = 18;
        ninjaDois.nomeJutso = "Chidori";
        ninjaDois.equipamento = "Shuriken";

        alunoNinja.apresentarse();
        ninjaDois.apresentarse();

        Hokage narutoHokage = new Hokage();

        ninjaDois.name = "Naruto";
        ninjaDois.aldeia = "Folha";
        ninjaDois.cla = "Uchiha";
        ninjaDois.idade = 18;
        ninjaDois.nomeJutso = "Chidori";
        ninjaDois.equipamento = "Shuriken";

        alunoNinja.realizarInvocacao();
        narutoHokage.realizarInvocacao();
    }

}
