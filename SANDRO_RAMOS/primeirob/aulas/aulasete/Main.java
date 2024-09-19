package primeirob.aulas.aulasete;

public class Main {

    public static void main(String[] args) {
        Ninja ninja = new Ninja("Sandrolax", "Folha");
        AlunoNinja alunoNinja = new AlunoNinja("Roberto","Folha", "Jacy");
    
        System.out.println(ninja.getNome());
        System.out.println(alunoNinja.getNome());
        System.out.println(alunoNinja.getProfessor());
    }

}
