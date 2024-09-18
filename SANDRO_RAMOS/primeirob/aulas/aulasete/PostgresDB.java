package primeirob.aulas.aulasete;

public class PostgresDB implements IBancoDados {

    @Override
    public void salvar() {
        System.out.println("Salvando dados no PG");
    }
    
    @Override
    public void buscar() {
        System.out.println("Buscando dados no PG");
    }
    
    @Override
    public void atualizar() {
        System.out.println("Atualizando dados no PG");
    }
    
    @Override
    public void deletar() {
        System.out.println("Deletando dados no PG");
    }
    
}
