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

    public static void gravaArquivo(String conteudo, String LocalDoArquivo) {
        File arFile = new File(LocalDoArquivo);
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
            if (!LocalDoArquivo.equals("historicodevendas.csv")) {
                writer.write("dia do fechamento;quantidade;valor;valor inserido pelo usuario\n");
                writer.append(conteudo + "\n");
                return;
            }
            writer.write("hora da venda;Total da venda;quantidade;desconto\n");
            writer.append(conteudo + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lerArquivo(String caminho) {
        File arFile = new File(caminho);
        if (arFile.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(arFile))) {
                String linha;
                // imprime o cabeçalho da tabela
                if ((linha = br.readLine()) != null) {
                    System.out.println(formatarLinha(linha));
                }
                // imprime o corpo da tabela
                while ((linha = br.readLine()) != null) {
                    System.out.println(formatarLinha(linha));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Erro: Historico de vendas não encontrado");
        }
    }

    static void gravaTotalDeVendasDoDia(String conteudoString, String LocalDoArquivo) {
        gravaArquivo(conteudoString, LocalDoArquivo);
    }

    public static String formatarLinha(String linha) {
        //usa o ; para separa a string lida, e usa o essa separação para formatar a exibição na tela
        String[] campos = linha.split(";");
        return String.format("%-20s | %-14s | %-8s | %-8s", campos[0], campos[1], campos[2], campos.length > 3 ? campos[3] : "");
    }

    public static String formataHora() {
        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return timestamp.format(formatter);
    }

    public static void ProcurarNoArquivo(String caminho,String busca) {
        File arFile = new File(caminho);
        if (arFile.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(arFile))) {
                String linha;
                // imprime o cabeçalho da tabela
                if ((linha = br.readLine()) != null) {
                    System.out.println(formatarLinha(linha));
                }
                // imprime o corpo da tabela
                while ((linha = br.readLine()) != null) {
                    if (linha.contains(busca)){
                        System.out.println(formatarLinha(linha));
                    };
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Erro: " + caminho);
        }
    }
}