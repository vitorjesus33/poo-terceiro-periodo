package primeirob.aulas.aulacinco;

public class ProfessorTest {

    public static void main(String[] args) {
        Professor profeUm = new Professor();
        Professor profeDois = new Professor();

        Arma awp = new Arma();

        awp.nome = "AWP";
        awp.dano = 120;
        awp.skin = "Fever Dream";
        awp.tipo = "Rifle";
    
        profeUm.nome = "Melon musk";
        profeUm.materia = "Space X";
        profeUm.qualificacao = "Especialista";
        profeUm.genteBoa = true;

        profeDois.nome = "Elaine";
        profeDois.materia = "I.E.S";
        profeDois.qualificacao = "Doutora";
        profeDois.genteBoa = true;

        profeUm.arma = awp;

        profeUm.apresentarse();
        profeDois.apresentarse();
    }

}
