package ERICK_SCUR.primeirob.listas.lista3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculadoraLojaPlantas {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Venda> vendasDiarias = new HashMap<>();

    public static void main(String[] args) {
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("Escolha uma opção:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Registrar Venda");
            System.out.println("[4] - Salvar Vendas Diárias");
            System.out.println("[5] - Consultar Vendas");
            System.out.println("[6] - Sair");
            opcao = obterOpcaoValida(1, 6);

            switch (opcao) {
                case 1:
                    calcularPrecoTotal();
                    break;
                case 2:
                    calcularTroco();
                    break;
                case 3:
                    registrarVenda();
                    break;
                case 4:
                    salvarVendasDiarias();
                    break;
                case 5:
                    consultarVendas();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
        scanner.close();
    }

    private static void calcularPrecoTotal() {
        System.out.println("Digite a quantidade de plantas:");
        int quantidade = obterQuantidadeValida();
        System.out.println("Digite o preço unitário:");
        double precoUnitario = obterPrecoUnitarioValido();
        double precoTotal = calcularValorTotalComDesconto(quantidade, precoUnitario);
        System.out.println("Preço total: R$ " + precoTotal);
    }

    private static double calcularValorTotalComDesconto(int quantidade, double precoUnitario) {
        double precoTotal = quantidade * precoUnitario;
        if (quantidade > 10) {
            precoTotal *= 0.95;
            System.out.println("Desconto especial de 5% aplicado!");
        }
        return precoTotal;
    }

    private static void calcularTroco() {
        System.out.println("Digite o valor recebido:");
        double valorRecebido = obterValorMonetarioValido();
        System.out.println("Digite o valor total da compra:");
        double valorTotal = obterValorMonetarioValido();
        double troco = valorRecebido - valorTotal;
        if (troco < 0) {
            System.out.println("Erro: O valor recebido é menor que o valor total da compra.");
        } else {
            System.out.println("Troco: R$ " + troco);
        }
    }

    private static void registrarVenda() {
        System.out.println("Digite a quantidade de plantas:");
        int quantidade = obterQuantidadeValida();
        System.out.println("Digite o preço unitário:");
        double precoUnitario = obterPrecoUnitarioValido();
        double valorTotal = calcularValorTotalComDesconto(quantidade, precoUnitario);

        Venda venda = new Venda(quantidade, precoUnitario, valorTotal);

        System.out.println("Venda registrada com sucesso!");
        System.out.println(venda);
    }

    private static void salvarVendasDiarias() {
        System.out.println("Digite o dia (1-30):");
        int dia = obterDiaValido();
        System.out.println("Digite o mês (1-12):");
        int mes = obterMesValido();
        System.out.println("Digite a quantidade total de vendas do dia:");
        int quantidadeVendas = obterQuantidadeValida();

        String chave = dia + "-" + mes;
        Venda vendaDiaria = new Venda(quantidadeVendas, 0, 0); // Para vendas diárias, estamos focando na quantidade
        vendasDiarias.put(chave, vendaDiaria);

        System.out.println("Vendas diárias salvas com sucesso!");
    }

    private static void consultarVendas() {
        System.out.println("Digite [1] para consultar por dia ou [2] para consultar por mês:");
        int opcao = obterOpcaoValida(1, 2);

        if (opcao == 1) {
            System.out.println("Digite o dia (1-30):");
            int dia = obterDiaValido();
            System.out.println("Digite o mês (1-12):");
            int mes = obterMesValido();

            String chave = dia + "-" + mes;
            Venda vendaDoDia = vendasDiarias.getOrDefault(chave, new Venda(0, 0, 0));

            System.out.println("Vendas totais do dia " + dia + "/" + mes + ": " + vendaDoDia.getQuantidade());
        } else if (opcao == 2) {
            System.out.println("Digite o mês (1-12):");
            int mes = obterMesValido();

            int vendasDoMes = 0;
            for (int dia = 1; dia <= 30; dia++) {
                String chave = dia + "-" + mes;
                vendasDoMes += vendasDiarias.getOrDefault(chave, new Venda(0, 0, 0)).getQuantidade();
            }

            System.out.println("Vendas totais do mês " + mes + ": " + vendasDoMes);
        } else {
            System.out.println("Opção inválida!");
        }
    }

    // Métodos de Validação

    private static int obterOpcaoValida(int min, int max) {
        int opcao;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Erro: Entrada inválida. Digite um número entre " + min + " e " + max + ".");
                scanner.next();
            }
            opcao = scanner.nextInt();
            if (opcao < min || opcao > max) {
                System.out.println("Erro: Digite um número entre " + min + " e " + max + ".");
            }
        } while (opcao < min || opcao > max);
        return opcao;
    }

    private static int obterQuantidadeValida() {
        int quantidade;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Erro: Entrada inválida. Digite um número inteiro positivo.");
                scanner.next();
            }
            quantidade = scanner.nextInt();
            if (quantidade <= 0) {
                System.out.println("Erro: A quantidade deve ser um número inteiro positivo.");
            }
        } while (quantidade <= 0);
        return quantidade;
    }

    private static double obterPrecoUnitarioValido() {
        double precoUnitario;
        do {
            while (!scanner.hasNextDouble()) {
                System.out.println("Erro: Entrada inválida. Digite um número decimal positivo.");
                scanner.next();
            }
            precoUnitario = scanner.nextDouble();
            if (precoUnitario <= 0) {
                System.out.println("Erro: O preço unitário deve ser um número decimal positivo.");
            }
        } while (precoUnitario <= 0);
        return precoUnitario;
    }

    private static double obterValorMonetarioValido() {
        double valor;
        do {
            while (!scanner.hasNextDouble()) {
                System.out.println("Erro: Entrada inválida. Digite um número decimal positivo.");
                scanner.next();
            }
            valor = scanner.nextDouble();
            if (valor < 0) {
                System.out.println("Erro: O valor deve ser um número decimal positivo.");
            }
        } while (valor < 0);
        return valor;
    }

    private static int obterDiaValido() {
        return obterOpcaoValida(1, 30);
    }

    private static int obterMesValido() {
        return obterOpcaoValida(1, 12);
    }
}
