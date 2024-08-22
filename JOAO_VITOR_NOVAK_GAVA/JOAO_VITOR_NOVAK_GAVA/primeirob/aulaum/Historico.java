package JOAO_VITOR_NOVAK_GAVA.primeirob.aulaum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Historico {
    private static final List<Registro> registros = new ArrayList<>();
    private static String nomeArquivo;

    public Historico(String nomeArquivo) {
        Historico.nomeArquivo = nomeArquivo;

        // Criar o arquivo CSV com o cabeçalho, se necessário
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            if (new File(nomeArquivo).length() == 0) { // Verifica se o arquivo está vazio
                writer.write("Quantidade,Total,Desconto");
                writer.newLine();
            }
        } catch (IOException e) {
        }
    }

    public void adicionarRegistro(Registro registro) {
        registros.add(registro);

        // Gravar no arquivo CSV
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write(registro.toString());
            writer.newLine();
        } catch (IOException e) {
        }
    }

    public static void exibirHistorico() {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            boolean isFirstLine = true; // Ignorar o cabeçalho

            System.out.println("Histórico de Preços:");
            while ((linha = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Pula a primeira linha (cabeçalho)
                    continue;
                }

                String[] dados = linha.split(",");
                int quantidade = Integer.parseInt(dados[0]);
                float total = Float.parseFloat(dados[1]);
                boolean desconto = "Sim".equals(dados[2]);

                // Cria o registro a partir da linha do CSV
                Registro registro = new Registro(quantidade, total, desconto);
                registros.add(registro);

                // Exibe os dados do registro
                System.out.println("Quantidade: " + registro.getQuantidade() + ", Total: R$ " + registro.getTotal()
                        + ", Desconto: " + (registro.isDesconto() ? "Sim" : "Não"));
            }
        } catch (IOException e) {
        }
    }
}
