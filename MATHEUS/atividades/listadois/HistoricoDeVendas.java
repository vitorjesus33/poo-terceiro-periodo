import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class HistoricoDeVendas {

    public static void gravaArquivo(String conteudo) {
        File arFile = new File("historicodevendas.csv");
        conteudo = formataHora() + ";" + conteudo; 
        if (arFile.exists()) {
            try {
                Writer arquivo = new BufferedWriter(new FileWriter(arFile, true));
                arquivo.append(conteudo + "\n");
                arquivo.close();
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileWriter writer = new FileWriter(arFile)) {
            writer.write("hora da venda;Total da venda;quantidade;desconto\n");
            writer.append(conteudo + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lerArquivo(){
        File arFile = new File("historicodevendas.csv");
        if (arFile.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(arFile))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.replace(String.valueOf(";"), " | ");
                System.out.println(linha);
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Erro: Historico de vendas não encontrado");
        }
    }

    public static String formataHora(){
        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return timestamp.format(formatter);
    }
}