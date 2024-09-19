package primeirob.aulas.aulasete;

public class Ninja {
    
    private String nome;

    private String aldeiaMora;

    public Ninja(String nome, String aldeiaMora) {
        this.nome = nome;
        this.aldeiaMora = aldeiaMora;
    }

    public String getNome() {
        return nome;
    }

    public String getAldeiaMora() {
        return aldeiaMora;
    }

    public void setAldeiaMora(String aldeiaMora) {
        this.aldeiaMora = aldeiaMora;
    }

}
