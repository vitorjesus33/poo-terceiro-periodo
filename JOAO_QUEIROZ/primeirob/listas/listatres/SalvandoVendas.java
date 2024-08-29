package primeirob.listas.listatres;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SalvandoVendas {

    private static final int[][] vendasDiarias = new int[12][30];
    public static void main(String[] args) {

        carregarVendasDoArquivo();

        try (Scanner leitor = new Scanner(System.in)) {
            OUTER: 
            do {
                System.out.println("--Menu--\n[1]Desconto\n[2]Registro de Vendas\n[3]Salvar vendas no dia\n[4]Consultar as vendas no dia\n[5]Consultar todos os dias com vendas\n[6]Sair");
                int escolha = leitor.nextInt();
                switch (escolha) {
                    case 1 -> {
                        System.out.println("Informe a quantidade da planta: \n");
                        int quantidade = leitor.nextInt();
                        System.out.println("Informe o valor da planta: \n");
                        double valor = leitor.nextDouble();
                        double total = quantidade * valor;
                        double valorDesconto = total - (total)*5/100;
                        if (quantidade >= 10) {
                            System.out.println("Você ganhou 5% de desconto!!");
                            System.out.println("Valor total "+valorDesconto);
                            registrarVenda(quantidade, valor, valorDesconto);
                        } else {
                            System.out.println("Valor total "+ total);
                            registrarVenda(quantidade, valor, total);
                        }
                    }
                    case 2 -> exibirRegistrosDeVendas();
                    case 3 -> salvarVendasDoDia(leitor);
                    case 4 -> consultarVendasPorDia(leitor);
                    case 5 -> consultarTodosDiasDeVendas();
                    case 6 -> {
                        System.out.println("Saindo...");
                        salvarVendasParaArquivo();
                        break OUTER;
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } while (true);
        }
    }
    private static void registrarVenda(int quantidade, double valor, double valorDesconto) {
        String nomeArquivo = "registro_vendas.csv";
        boolean arquivoExiste = new java.io.File(nomeArquivo).exists();
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            if (!arquivoExiste) {
                writer.write("Quantidade, Preço Unitário, Valor com Desconto\n");
            }
            writer.write(quantidade + " -> " + String.format("%.2f", valor) + " -> " + String.format("%.2f", valorDesconto) + "\n");
            System.out.println("Venda registrada com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar a venda no arquivo: " + e.getMessage());
        }
    }
    private static void exibirRegistrosDeVendas() {
        String nomeArquivo = "registro_vendas.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            System.out.println("\n--- Registro de Vendas ---");
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de vendas: " + e.getMessage());
        }
    }
    private static void salvarVendasDoDia(Scanner leitor){
        System.out.println("Informe o mês (1-12)");
        int mes = leitor.nextInt() -1;

        System.out.println("Informe o dia (1-30)");
        int dia = leitor.nextInt() -1;

        System.out.println("Informe a quantidade de vendas no dia: ");
        int vendasTotais = leitor.nextInt();

        vendasDiarias[mes][dia] = vendasTotais;
        System.out.println("Vendas do dia registradas com sucesso!");
    }
    private static  void consultarVendasPorDia(Scanner leitor) {
        System.out.println("Informe o mês (1-12) para consultar");
        int mes = leitor.nextInt() -1 ;

        System.out.println("Informe o dia (1-30)");
        int dia = leitor.nextInt()  -1 ;

        int vendasTotais = vendasDiarias[mes][dia];
        System.out.println("Total de vendas no dia: "+ (dia + 1)+ "/"+ (mes + 1)+ ": "+ vendasTotais);
    }
    private static void consultarTodosDiasDeVendas() {
        System.out.println("\n---- Dias de vendas registradas ----");
        boolean vendasEncontradas = false;
        for (int mes = 0; mes < 12; mes++) {
            for (int dia = 0; dia < 30; dia++) {
                if (vendasDiarias[mes][dia] > 0) {
                    System.out.println("Mês: "+ (mes + 1) + " Dia: "+ (dia + 1)+ " - Vendas: "+vendasDiarias[mes][dia]);
                    vendasEncontradas = true;
                }
            }
        }
        if (!vendasEncontradas) {
            System.out.println("Nenhuma venda registrada.");
        }
    }    
    private static void carregarVendasDoArquivo() {
        String nomeArquivo = "Vendas_Diarias.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))){
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                int mes = Integer.parseInt(dados[0])- 1;
                int dia = Integer.parseInt(dados[1])- 1;
                int vendasTotais = Integer.parseInt(dados[2]);

                vendasDiarias[mes][dia] = vendasTotais;
            }
        } catch (IOException e) {
            System.out.println("Arquivo de vendas diárias não encontrado. Um novo arquivo será criado.");
        }
    }
    private static void salvarVendasParaArquivo() {
        String nomeArquivo = "vendas_diarias.csv";
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            // Salva os dados da matriz no arquivo CSV
            for (int mes = 0; mes < 12; mes++) {
                for (int dia = 0; dia < 30; dia++) {
                    writer.write((mes + 1) + "," + (dia + 1) + "," + vendasDiarias[mes][dia] + "\n");
                }
            }
            System.out.println("Vendas diárias salvas no arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar vendas diárias no arquivo: " + e.getMessage());
        }
    }
}