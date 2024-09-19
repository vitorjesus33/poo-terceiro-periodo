package CREDIANE_SIQUEIRA.primeirob.aulas.aulas.aulacinco;

public class ProfessorTest {
    public static void main(String[] args) {
        Professor profeUm = new Professor();
        Professor profeDois = new Professor();
        profeDois.nome = "Cesar ";
        profeUm.nome = "Crediane ";
        profeUm.materia = " Pedagogia";
        profeDois.materia = " Fisica";

        profeDois.apresentarse();
        profeUm.apresentarse(); 
    }
}
