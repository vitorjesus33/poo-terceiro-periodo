package primeirob.listas.listadois;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Desconto {

    public static void main(String[] args) {

        try (Scanner leitor = new Scanner(System.in)) {
            OUTER: 
            do {
                System.out.println("--Menu--\n[1]Desconto\n[2]Registro de Vendas\n");
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
                    case 3 -> {
                        System.out.println("Saindo...");
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
}
