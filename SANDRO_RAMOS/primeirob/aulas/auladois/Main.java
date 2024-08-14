package primeirob.aulas.auladois;

public class Main {
    
    public static void main(String[] args) {
        ExemploAcesso exemplo = new ExemploAcesso();
        System.out.println(ExemploAcesso.VALOR_IMUTAVEL);

        exemplo.idadeDois = 20;

        System.out.println(exemplo.idadeDois);
        System.out.println(exemplo.VALOR_IMUTAVEL);
    }

}