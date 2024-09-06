package MURILO_WOLFF.primeirob.listas.listatres;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculadora{
    private static ArrayList<String> registroVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int escolha;

        do {
            System.out.println("""
                    -- Menu --
                    [1] - Calcular preço geral
                    [2] - Calcular Troco
                    [3] - Verificar vendas
                    [4] - Menu Vendas (Salvar/Carregar)
                    [5] - Checar Vendas (Mensal/Diária)
                    [6] - Sair
                    """);
            escolha = leitor.nextInt();

            switch (escolha) {
                case 1:
                    calculoPrecoGeral(leitor);
                    break;
                case 2:
                    calcularTroco(leitor);
                    break;
                case 3:
                    verificarVendas(leitor);
                    break;
                case 4:
                    VendasCsv.menu(leitor);
                    break;
                case 5:
                    ChecarVendasCsv.menu(leitor);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 6);

        leitor.close();
    }

    static void logVendas(int qtdPlantas, double precoUnitario, double valorTotal, boolean descontoAplicado) {
        String registro = "Quantidade: " + qtdPlantas + ", Preço Unitário: R$" + precoUnitario +
                ", Valor Total: R$" + valorTotal + ", Desconto Aplicado: " + (descontoAplicado ? "Sim" : "Não");
        registroVendas.add(registro);
    }

    static void calculoPrecoGeral(Scanner leitor) {
        System.out.println("Insira a quantidade de plantas compradas: ");
        int qtdPlantas = leitor.nextInt();

        System.out.println("Insira o preço unitário das plantas: ");
        double preco = leitor.nextDouble();

        double valorTotal = qtdPlantas * preco;
        boolean descontoAplicado = false;

        if (qtdPlantas > 10) {
            valorTotal *= 0.95;
            descontoAplicado = true;
        }

        System.out.println("Preço total das plantas compradas: R$" + valorTotal);
        logVendas(qtdPlantas, preco, valorTotal, descontoAplicado);
    }

    static void calcularTroco(Scanner leitor) {
        System.out.println("Valor recebido: ");
        double dinValor = leitor.nextDouble();

        System.out.println("Valor total das plantas compradas: ");
        double totalCompra = leitor.nextDouble();

        System.out.println("Valor do troco: R$" + (dinValor - totalCompra));
    }

    static void verificarVendas(Scanner leitor) {
        int tamanhoPagina = 5;
        int paginaAtual = 0;

        while (paginaAtual * tamanhoPagina < registroVendas.size()) {
            int inicio = paginaAtual * tamanhoPagina;
            int fim = Math.min(inicio + tamanhoPagina, registroVendas.size());

            System.out.println("\n-- Vendas Página " + (paginaAtual + 1) + " --");
            for (int i = inicio; i < fim; i++) {
                System.out.println(registroVendas.get(i));
            }

            System.out.println("\n[1] Próxima Página | [2] Página Anterior | [3] Sair");
            int escolha = leitor.nextInt();

            if (escolha == 1) {
                if ((paginaAtual + 1) * tamanhoPagina < registroVendas.size()) {
                    paginaAtual++;
                } else {
                    System.out.println("Você já está na última página.");
                }
            } else if (escolha == 2) {
                if (paginaAtual > 0) {
                    paginaAtual--;
                } else {
                    System.out.println("Você já está na primeira página.");
                }
            } else if (escolha == 3) {
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public class VendasCsv {
        private static Path caminho = Paths.get("MURILO_WOLFF/primeirob/listas/listatres/vendas.csv");
        private static String[] headerVenda = {"Data", "Quantidade"};
        private static ArrayList<String[]> linhas = new ArrayList<>();

        public static void menu(Scanner leitor) {
            int escolha;
            do {
                System.out.println(("""
                        -- Menu --
                        [1] - Lançar vendas
                        [2] - Salvar
                        [3] - Sair
                        """));
                escolha = leitor.nextInt();
                leitor.nextLine();

                switch (escolha) {
                    case 1:
                        lancarVendas(leitor);
                        break;
                    case 2:
                        salvarCsv();
                        break;
                    case 3:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            }while (escolha != 3);
        }

        static void lancarVendas(Scanner leitor) {
            System.out.println("Qual é a data de hoje? (dd/mm)");
            String data = leitor.nextLine();

            System.out.println("Qual foi a quantidade vendida?");
            String qtd = leitor.nextLine();

            linhas.add(new String[]{data, qtd});

            System.out.println("Venda lançada com sucesso!");
        }

        static void salvarCsv() {
            boolean arquivoExiste = !Files.exists(caminho);
            try(BufferedWriter writer = Files.newBufferedWriter(caminho, StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
                if(arquivoExiste){
                    writer.write(String.join(",", headerVenda));
                    writer.newLine();
                }

                for(String[] linha: linhas){
                    writer.write(String.join(",", linha));
                    writer.newLine();
                }

                linhas.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.printf("");
        }
    }

    public class ChecarVendasCsv {
        private static Path caminho = Paths.get("MURILO_WOLFF/primeirob/listas/listatres/vendas.csv");

        public static void menu(Scanner leitor) {
            int escolha;
            do {
                System.out.println(("""
                        -- Menu --
                        [1] - Checar vendas diária
                        [2] - Checar vendas mensal
                        [3] - Sair
                        """));
                escolha = leitor.nextInt();
                leitor.nextLine();

                switch (escolha) {
                    case 1:
                        checarVendasDiaria(leitor);
                        break;
                    case 2:
                        checarVendasMensal(leitor);
                        break;
                    case 3:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            }while (escolha != 2);
        }

        static void checarVendasMensal(Scanner leitor) {
            System.out.println("Qual é o mês que deseja checar? (mm)");
            String mes = leitor.nextLine();

            try(Scanner reader = new Scanner(caminho)){
                reader.nextLine();

                while(reader.hasNextLine()){
                    String[] linha = reader.nextLine().split(",");
                    if(linha[0].split("/")[1].equals(mes)){
                        System.out.println("Data: " + linha[0] + " | Quantidade: " + linha[1]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        static void checarVendasDiaria(Scanner leitor) {
            System.out.println("Qual é o dia e mês que deseja checar? (dd/mm)");
            String data = leitor.nextLine();

            try(Scanner reader = new Scanner(caminho)){
                reader.nextLine();

                while(reader.hasNextLine()){
                    String[] linha = reader.nextLine().split(",");
                    if(linha[0].equals(data)){
                        System.out.println("Data: " + linha[0] + " | Quantidade: " + linha[1]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
