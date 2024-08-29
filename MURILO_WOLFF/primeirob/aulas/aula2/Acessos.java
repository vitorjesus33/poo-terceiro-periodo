package MURILO_WOLFF.primeirob.aulas.aula2;

public class Acessos {
    public static void main(String[] args) {
        // Acessos
        // Acessos são as permissões que damos para que outras classes acessem nossas classes, métodos e atributos.
        // public: acessível por todos
        // private: acessível apenas pela própria classe
        // protected: acessível pela própria classe e por classes do mesmo pacote
        // default: acessível pela própria classe e por classes do mesmo pacote

        // public
        // Acessível por todos
        // Exemplo: System.out.println("Olá, mundo!");

        // private
        // Acessível apenas pela própria classe
        // Exemplo: private int idade = 20;

        // protected
        // Acessível pela própria classe e por classes do mesmo pacote
        // Exemplo: protected String nome = "Murilo";

        // default
        // Acessível pela própria classe e por classes do mesmo pacote
        // Exemplo: String sobrenome = "Wolff";

        // Exemplo de uso de acessos:
        // public class Pessoa {
        //     private int idade = 20;
        //     protected String nome = "Murilo";
        //     String sobrenome = "Wolff";
        // }

        // public class Funcionario
        //     public static void main(String[] args) {
        //         Pessoa pessoa = new Pessoa();
        //         System.out.println(pessoa.nome);
        //         System.out.println(pessoa.sobrenome);
        //         System.out.println(pessoa.idade);
        //     }
        //
        //     // O código acima não funcionará, pois os atributos da classe Pessoa são privados e protegidos, e a classe Funcionario não tem acesso a eles.

        // public class Funcionario
        //     public static void main(String[] args) {
        //         Pessoa pessoa = new Pessoa();
        //         System.out.println(pessoa.nome);
        //         System.out.println(pessoa.sobrenome);
        //     }
        //
        //     // O código acima funcionará, pois os atributos nome e sobrenome da classe Pessoa são acessíveis pela classe Funcionario.

        // static
        // O modificador static é utilizado para que um método ou atributo pertença à classe, e não a uma instância da classe.

        // Exemplo:

        // public class Pessoa {
        //     private static int idade = 20;
        //     private String nome = "Murilo";
        //     private String sobrenome = "Wolff";
        // }
        //

        // public class Funcionario
        //     public static void main(String[] args) {
        //         Pessoa pessoa = new Pessoa();
        //         System.out.println(pessoa.nome);
        //         System.out.println(pessoa.sobrenome);
        //         System.out.println(pessoa.idade);
        //     }
        //

        // O código acima não funcionará, pois o atributo idade da classe Pessoa é estático, e a classe Funcionario não tem acesso a ele.

        // public class Funcionario
        //     public static void main(String[] args) {
        //         Pessoa pessoa = new Pessoa();
        //         System.out.println(pessoa.nome);
        //         System.out.println(pessoa.sobrenome);
        //         System.out.println(Pessoa.idade);
        //     }

        // O código acima funcionará, pois o atributo idade da classe Pessoa é estático, e a classe Funcionario tem acesso a ele.

        // final
    }
}
