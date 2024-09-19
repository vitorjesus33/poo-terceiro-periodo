package primeirob.aulas.aulasete;

public class MainDB {
    
    public static void main(String[] args) {
        PostgresDB pg = new PostgresDB();
        MariaDB mariaDB = new MariaDB();

        salvar(mariaDB);
    }

    public static void salvar(IBancoDados bancoDados) {
        bancoDados.salvar();
    }

}
