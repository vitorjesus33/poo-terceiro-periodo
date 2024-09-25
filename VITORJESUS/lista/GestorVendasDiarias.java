import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    static class Venda {
        private int dia;
        private int mes;
        private int quantidade;

        public Venda(int dia, int mes, int quantidade) {
            this.dia = dia;
            this.mes = mes;
            this.quantidade = quantidade;
        }

        public int getDia() {
            return dia;
        }

        public int getMes() {
            return mes;
        }

        public int getQuantidade() {
            return quantidade;
        }

        @Override
        public String toString() {
            return "Dia " + dia + "/" + mes + ": " + quantidade + " vendas";
        }
    }

    static class RegistroVendas {
        private Map<String, Integer> vendasPorDia;

        public RegistroVendas() {
            vendasPorDia = new HashMap<>();
        }

        public void salvarVendas(int dia, int mes, int quantidade) {
            String chave = gerarChave(dia, mes);
            vendasPorDia.put(chave, quantidade);
            System.out.println("Vendas de " + quantidade + " no dia " + dia + "/" + mes + " salvas com sucesso!");
        }

        public int consultarVendas(int dia, int mes) {
            String chave = gerarChave(dia, mes);
            return vendasPorDia.getOrDefault(chave, 0);
        }

        private String gerarChave(int dia, int mes) {
            return dia + "/" + mes;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistroVendas registroVendas = new RegistroVendas();

        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Salvar vendas totais de um dia");
            System.out.println("2. Consultar vendas totais de um dia");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o dia: ");
                    int dia = scanner.nextInt();
                    System.out.print("Informe o mês: ");
                    int mes = scanner.nextInt();
                    System.out.print("Informe a quantidade de vendas: ");
                    int quantidade = scanner.nextInt();
                    registroVendas.salvarVendas(dia, mes, quantidade);
                    break;

                case 2:
                    System.out.print("Informe o dia: ");
                    dia = scanner.nextInt();
                    System.out.print("Informe o mês: ");
                    mes = scanner.nextInt();
                    int vendas = registroVendas.consultarVendas(dia, mes);
                    System.out.println("Total de vendas no dia " + dia + "/" + mes + ": " + vendas);
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
