import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LojaDePlantas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistroVendas registro = new RegistroVendas();

        while (true) {
            System.out.println("1. Registrar nova venda");
            System.out.println("2. Exibir registro de vendas");
            System.out.println("3. Sair");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Informe a quantidade de plantas: ");
                int quantidade = scanner.nextInt();
                System.out.print("Informe o preço unitário da planta: ");
                double precoUnitario = scanner.nextDouble();

                Venda venda = new Venda(quantidade, precoUnitario);
                registro.adicionarVenda(venda);

                System.out.println("Venda registrada com sucesso. Total a pagar: " + venda.calcularTotal());
            } else if (opcao == 2) {
                registro.exibirRegistro();
            } else if (opcao == 3) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}

class Venda {
    private int quantidade;
    private double precoUnitario;

    public Venda(int quantidade, double precoUnitario) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public double calcularTotal() {
        double total = quantidade * precoUnitario;
        if (quantidade > 10) {
            total *= 0.95; 
        }
        return total;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }
}

class RegistroVendas {
    private List<Venda> vendas;

    public RegistroVendas() {
        this.vendas = new ArrayList<>();
    }

    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
    }

    public void exibirRegistro() {
        for (Venda venda : vendas) {
            System.out.println("Quantidade: " + venda.getQuantidade() +
                               " | Preço Unitário: " + venda.getPrecoUnitario() +
                               " | Total com Desconto: " + venda.calcularTotal());
        }
    }
}
