package primeirob.aulas.aulasete;

public class MariaDB implements IBancoDados {

    @Override
    public void salvar() {
        System.out.println("Salvando dados no MariaDB");
    }
    
    @Override
    public void buscar() {
        System.out.println("Buscando dados no MariaDB");
    }
    
    @Override
    public void atualizar() {
        System.out.println("Atualizando dados no MariaDB");
    }
    
    @Override
    public void deletar() {
        System.out.println("Deletando dados no MariaDB");
    }
    
}
