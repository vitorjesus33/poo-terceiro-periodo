import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        float valorUnitarioPlanta, dinheiroRecebido, valorTotal = 0;
        int quantidadePlanta;
        int menu;
        try (Scanner entrada = new Scanner(System.in)) {
            do {
                System.out.println("selecione a opção doadfasdfasdf menu:\n1 - registar planta\n2 - finaliza venda\n0 - sair do sistema");
                menu = entrada.nextInt();

                switch (menu) {
                    case 1 -> {
                        // grava venda
                        System.out.println("digite o valor da planta comprada...");
                        valorUnitarioPlanta = entrada.nextFloat();
                        System.out.println("quantidade de plantas compradas");
                        quantidadePlanta = entrada.nextInt();
                        valorTotal = quantidadePlanta * valorUnitarioPlanta;
                    }
                    case 2 -> {
                        // finaliza venda
                        System.out.println("Digite o valor, pago valor total da compra = " + valorTotal);
                        dinheiroRecebido = entrada.nextFloat();
                        if (dinheiroRecebido < valorTotal) {
                            System.out.println("Pagamento insuficiente, valor faltante " + (valorTotal - dinheiroRecebido));
                            break;
                        }
                        System.out.println("seu troco é: " + (dinheiroRecebido - valorTotal) + "\n compra concluida");
                    }
                    case 0 -> {
                        System.out.println("sistema finalizado aperte entre para sair...");
                        entrada.nextLine();
                    }
                    default -> {
                    }
                }
            } while (menu != 0);
        }
    }
}