package JOAO_VITOR_NOVAK_GAVA.primeirob.listaTres;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Historico {
    private static List<Registro> registros = new ArrayList<>();
    private static String nomeArquivo = "historico.csv";

    public Historico(String nomeArquivo) {
        Historico.nomeArquivo = nomeArquivo;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            if (new File(nomeArquivo).length() == 0) { // Verifica se o arquivo está vazio
                writer.write("Quantidade,Total,Desconto,Data");
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionarRegistro(Registro registro) {
        registros.add(registro);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write(registro.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exibirHistorico() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            boolean isFirstLine = true;

            System.out.println("Histórico de Preços:");
            while ((linha = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] dados = linha.split(",");
                int quantidade = Integer.parseInt(dados[0]);
                float total = Float.parseFloat(dados[1]);
                boolean desconto = "Sim".equals(dados[2]);
                LocalDateTime data = LocalDateTime.parse(dados[3], formatter);

                Registro registro = new Registro(quantidade, total, desconto, data);
                registros.add(registro);

                System.out.println("Data: " + data.format(formatter) +
                        ", Quantidade: " + registro.getQuantidade() +
                        ", Total: R$ " + registro.getTotal() +
                        ", Desconto: " + (registro.isDesconto() ? "Sim" : "Não"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Registro> getRegistros() {
        return registros;
    }
}
