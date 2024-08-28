import java.util.Scanner;

public class ParadigmasProgramacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("----- MENU -----");
            System.out.println("[1] - Programação Imperativa");
            System.out.println("[2] - Programação Orientada a Objetos");
            System.out.println("[3] - Programação Funcional");
            System.out.println("[4] - Programação Lógica");
            System.out.println("[5] - Programação Reativa");
            System.out.println("[6] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    descricaoImperativa();
                    break;
                case 2:
                    descricaoOrientadaAObjetos();
                    break;
                case 3:
                    descricaoFuncional();
                    break;
                case 4:
                    descricaoLogica();
                    break;
                case 5:
                    descricaoReativa();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    private static void descricaoImperativa() {
        System.out.println("A programação imperativa foca em descrever como o programa deve realizar tarefas usando instruções sequenciais, condicionais e loops.");
    }

    private static void descricaoOrientadaAObjetos() {
        System.out.println("A POO estrutura o software em objetos que encapsulam dados e comportamentos, utilizando conceitos como classes, herança, polimorfismo e encapsulamento.");
    }

    private static void descricaoFuncional() {
        System.out.println("A programação funcional trata a computação como a avaliação de funções matemáticas, evitando estados e efeitos colaterais.");
    }

    private static void descricaoLogica() {
        System.out.println("A programação lógica é baseada em declarações de lógica e regras de inferência. Prolog é um exemplo de linguagem que utiliza esse paradigma.");
    }

    private static void descricaoReativa() {
        System.out.println("A programação reativa foca em fluxos de dados e na propagação de mudanças, sendo útil em interfaces gráficas e sistemas baseados em eventos.");
    }
}
