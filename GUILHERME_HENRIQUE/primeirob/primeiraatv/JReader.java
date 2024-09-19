package GUILHERME_HENRIQUE.primeirob.primeiraatv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JReader {

    public static void main(String[] args) {
        List<String> columns = new ArrayList<>();
        List<List<String>> rows = new ArrayList<>();
        
        Scanner input = new Scanner(System.in);
        
        try {
            // Obter os nomes das colunas
            System.out.println("Digite pelo menos três colunas:");
            while (columns.size() < 3) {
                System.out.print("Insira " + (columns.size() + 1) + "ª coluna: ");
                String column = input.nextLine();
                columns.add(column);
            }
            
            // Perguntar se deseja adicionar mais colunas
            while (true) {
                System.out.print("Deseja inserir mais uma coluna? (S/N): ");
                String chose = input.nextLine();
                if (chose.equalsIgnoreCase("N")) {
                    break;
                } else if (chose.equalsIgnoreCase("S")) {
                    System.out.print("Insira o nome da coluna: ");
                    String column = input.nextLine();
                    columns.add(column);
                } else {
                    System.out.println("Opção inválida. Responda com 'S' ou 'N'.");
                }
            }

            // Obter as linhas de dados
            while (true) {
                List<String> row = new ArrayList<>();
                for (String column : columns) {
                    System.out.print("Digite o valor para " + column + ": ");
                    String value = input.nextLine();
                    row.add(value);
                }
                rows.add(row);
                
                System.out.print("Deseja adicionar mais uma linha? (S/N): ");
                String chose = input.nextLine();
                if (chose.equalsIgnoreCase("N")) {
                    break;
                }
            }

            // Criar e escrever no arquivo CSV
            FileWriter writer = new FileWriter("exemplo_bala.csv");

            // Escrever cabeçalhos das colunas
            for (int i = 0; i < columns.size(); i++) {
                writer.append(columns.get(i));
                if (i < columns.size() - 1) {
                    writer.append(";");
                }
            }
            writer.append("\n");

            // Escrever linhas de dados
            for (List<String> row : rows) {
                for (int i = 0; i < row.size(); i++) {
                    writer.append(row.get(i));
                    if (i < row.size() - 1) {
                        writer.append(";");
                    }
                }
                writer.append("\n");
            }

            writer.flush();
            writer.close();
            System.out.println("Arquivo CSV criado com sucesso!");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
