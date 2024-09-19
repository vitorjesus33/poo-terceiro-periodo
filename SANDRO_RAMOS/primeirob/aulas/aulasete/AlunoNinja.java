package primeirob.aulas.aulasete;

public class AlunoNinja extends Ninja {
    
    private String professor;
    
    public AlunoNinja(String nome, String aldeia, String professor) {
        super(nome, aldeia);

        this.professor = professor;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

}
