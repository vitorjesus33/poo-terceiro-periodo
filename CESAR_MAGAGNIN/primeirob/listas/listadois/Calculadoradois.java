import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe Venda para armazenar os dados de cada venda
class Venda {
    private final int ordem;
    private final int quantidade;
    private final double valorVenda;
    private final double desconto;

    public Venda(int ordem, int quantidade, double valorVenda, double desconto) {
        this.ordem = ordem;
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
        this.desconto = desconto;
    }

    public int getOrdem() {
        return ordem;
    }

    @Override
    public String toString() {
        return String.format("Venda # %d - Quantidade: %d, Valor da Venda: R$ %.2f, Desconto concedido: R$ %.2f", ordem, quantidade, valorVenda, desconto);
    }

    public String toFileFormat() {
        return ordem + ";" + quantidade + ";" + valorVenda + ";" + desconto;
    }

    public static Venda fromFileFormat(String line) {
        String[] parts = line.split(";");
        int ordem = Integer.parseInt(parts[0]);
        int quantidade = Integer.parseInt(parts[1]);
        double valorVenda = Double.parseDouble(parts[2]);
        double desconto = Double.parseDouble(parts[3]);
        return new Venda(ordem, quantidade, valorVenda, desconto);
    }
}

// Classe RegistroVendas para gerenciar vendas e arquivo
class RegistroVendas {
    private final List<Venda> vendas;
    private final String arquivo;
    private int proximaOrdem;

    public RegistroVendas(String arquivo) {
        this.vendas = new ArrayList<>();
        this.arquivo = arquivo;
        this.proximaOrdem = 1;
        carregarVendas();
    }

    private void carregarVendas() {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Venda venda = Venda.fromFileFormat(line);
                vendas.add(venda);
                if (venda.getOrdem() >= proximaOrdem) {
                    proximaOrdem = venda.getOrdem() + 1;
                }
            }
        } catch (IOException e) {
            System.out.println("Nenhum registro anterior encontrado.");
        }
    }

    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
        salvarVendaNoArquivo(venda);
    }

    private void salvarVendaNoArquivo(Venda venda) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            writer.write(venda.toFileFormat());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar a venda no arquivo.");
        }
    }

    public Venda criarVenda(int quantidade, double valorVenda, double desconto) {
        return new Venda(proximaOrdem++, quantidade, valorVenda, desconto);
    }

    public void listarVendas() {
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            System.out.println("Registros de Vendas:\n");
            vendas.forEach(System.out::println);
        }
    }
}

// Classe principal que contém o menu e a lógica da calculadora
public class Calculadoradois {
    private final Scanner scanner;
    private final RegistroVendas registroVendas;

    public Calculadoradois() {
        this.scanner = new Scanner(System.in);
        this.registroVendas = new RegistroVendas("vendas.txt");
    }

    public static void main(String[] args) {
        new Calculadoradois().executar();
    }

    private void executar() {
        int opt;
        do {
            exibirMenu();
            opt = scanner.nextInt();
            processarOpcao(opt);
        } while (opt != 4);

        System.out.println("Obrigado por usar nossa ferramenta.");
    }

    private void exibirMenu() {
        System.out.println("\nMenu Console:");
        System.out.println("[1] - Calcular Venda");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Registro de vendas");
        System.out.println("[4] - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void processarOpcao(int opt) {
        switch (opt) {
            case 1 -> calcularPrecoTotal();
            case 2 -> calcularTroco();
            case 3 -> registroVendas.listarVendas();
            case 4 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida, tente novamente.");
        }
    }

    private void calcularPrecoTotal() {
        int quantidade = obterQuantidadePlantas();
        double valorUnitario = obterValorPlanta();
        double valorTotal = calcularValorTotal(quantidade, valorUnitario);
        double desconto = calcularDesconto(quantidade, valorTotal);

        registrarVenda(quantidade, valorTotal, desconto);
        exibirPrecoTotal(valorTotal, desconto);
    }

    private int obterQuantidadePlantas() {
        System.out.print("\nInsira a quantidade de plantas vendidas: ");
        return scanner.nextInt();
    }

    private double obterValorPlanta() {
        System.out.print("Insira o valor da planta: ");
        return scanner.nextDouble();
    }

    private double calcularValorTotal(int quantidade, double valorUnitario) {
        return quantidade * valorUnitario;
    }

    private double calcularDesconto(int quantidade, double valorTotal) {
        return (quantidade >= 10) ? valorTotal * 0.05 : 0;
    }

    private void registrarVenda(int quantidade, double valorTotal, double desconto) {
        Venda venda = registroVendas.criarVenda(quantidade, valorTotal, desconto);
        registroVendas.adicionarVenda(venda);
    }

    private void exibirPrecoTotal(double valorTotal, double desconto) {
        double valorFinal = valorTotal - desconto;
        if (desconto > 0) {
            System.out.printf("Com 5%% de desconto, o valor total da compra é R$ %.2f%n", valorFinal);
        } else {
            System.out.printf("O preço total é R$ %.2f%n", valorFinal);
        }
    }

    private void calcularTroco() {
        System.out.print("\nInsira o valor pago pelo cliente: ");
        double valorPago = scanner.nextDouble();
        System.out.print("Insira o valor da compra: ");
        double valorCompra = scanner.nextDouble();
        double troco = calcularTroco(valorPago, valorCompra);

        exibirTroco(troco);
    }

    private double calcularTroco(double valorPago, double valorCompra) {
        return valorPago - valorCompra;
    }

    private void exibirTroco(double troco) {
        System.out.printf("O valor do troco é R$ %.2f%n", troco);
    }
}
