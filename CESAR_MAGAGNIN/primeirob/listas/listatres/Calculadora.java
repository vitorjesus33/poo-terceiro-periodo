package CESAR_MAGAGNIN.primeirob.listas.listatres;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Calculadora {
    private final Scanner scanner;
    private final List<Venda> vendas;
    private final String arquivo;
    private int proximaOrdem;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Calculadora() {
        this.scanner = new Scanner(System.in);
        this.vendas = new ArrayList<>();
        this.arquivo = "vendas.csv";
        this.proximaOrdem = 1;
        carregarVendas();
    }

    public static void main(String[] args) {
        new Calculadora().executar();
    }

    private void executar() {
        int opt;
        do {
            exibirMenu();
            opt = scanner.nextInt();
            processarOpcao(opt);
        } while (opt != 5);

        System.out.println("Obrigado por usar nossa ferramenta.");
    }

    private void exibirMenu() {
        System.out.println("\nMenu Console:");
        System.out.println("[1] - Registrar Venda");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Listar Vendas");
        System.out.println("[4] - Consultar Vendas");
        System.out.println("[5] - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void processarOpcao(int opt) {
        switch (opt) {
            case 1 -> calcularPrecoTotal();
            case 2 -> calcularTroco();
            case 3 -> listarVendas();
            case 4 -> consultarVendasPorDiaOuMes();
            case 5 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida, tente novamente.");
        }
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

    private void salvarVendaNoArquivo(Venda venda) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            writer.write(venda.toFileFormat());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar a venda no arquivo.");
        }
    }

    private void calcularPrecoTotal() {
        int quantidade = obterQuantidadePlantas();
        double valorUnitario = obterValorPlanta();
        double valorTotal = calcularValorTotal(quantidade, valorUnitario);
        double desconto = calcularDesconto(quantidade, valorTotal);

        LocalDate data = LocalDate.now();  // Usar a data atual
        registrarVenda(quantidade, valorTotal, desconto, data);
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

    private void registrarVenda(int quantidade, double valorTotal, double desconto, LocalDate data) {
        Venda venda = new Venda(proximaOrdem++, quantidade, valorTotal, desconto, data);
        vendas.add(venda);
        salvarVendaNoArquivo(venda);
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

    private void listarVendas() {
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            System.out.println("Registros de Vendas:\n");
            vendas.forEach(System.out::println);
        }
    }

    private void consultarVendasPorDiaOuMes() {
        System.out.println("[1] - Consultar vendas por dia");
        System.out.println("[2] - Consultar vendas por mês");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();

        if (escolha == 1) {
            consultarVendasPorDia();
        } else if (escolha == 2) {
            consultarVendasPorMes();
        } else {
            System.out.println("Opção inválida.");
        }
    }

    private void consultarVendasPorDia() {
        System.out.print("Insira a data (DD-MM-AAAA): ");
        String dataStr = scanner.next();
        LocalDate data = LocalDate.parse(dataStr, DATE_FORMATTER);
        long totalVendas = vendas.stream()
                                 .filter(venda -> venda.getData().equals(data))
                                 .count();
        System.out.printf("Total de vendas no dia %s: %d%n", data.format(DATE_FORMATTER), totalVendas);
    }

    private void consultarVendasPorMes() {
        System.out.print("Insira o ano (AAAA): ");
        int ano = scanner.nextInt();
        System.out.print("Insira o mês (1-12): ");
        int mes = scanner.nextInt();
        long totalVendas = vendas.stream()
                                 .filter(venda -> venda.getData().getYear() == ano && venda.getData().getMonthValue() == mes)
                                 .count();
        System.out.printf("Total de vendas no mês %d/%d: %d%n", mes, ano, totalVendas);
    }
}

// Classe Venda ajustada para ser usada na classe Calculadora
class Venda {
    private final int ordem;
    private final int quantidade;
    private final double valorVenda;
    private final double desconto;
    private final LocalDate data;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Venda(int ordem, int quantidade, double valorVenda, double desconto, LocalDate data) {
        this.ordem = ordem;
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
        this.desconto = desconto;
        this.data = data;
    }

    public int getOrdem() {
        return ordem;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return String.format("Venda # %d - Quantidade: %d, Valor da Venda: R$ %.2f, Desconto concedido: R$ %.2f, Data: %s",
                             ordem, quantidade, valorVenda, desconto, data.format(FORMATTER));
    }

    public String toFileFormat() {
        return ordem + ";" + quantidade + ";" + valorVenda + ";" + desconto + ";" + data.format(FORMATTER);
    }

    public static Venda fromFileFormat(String line) {
        String[] parts = line.split(";");
        int ordem = Integer.parseInt(parts[0]);
        int quantidade = Integer.parseInt(parts[1]);
        double valorVenda = Double.parseDouble(parts[2]);
        double desconto = Double.parseDouble(parts[3]);
        LocalDate data = LocalDate.parse(parts[4], FORMATTER);
        return new Venda(ordem, quantidade, valorVenda, desconto, data);
    }
}