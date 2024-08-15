import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static int option;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            showOptions();
        } while (option != 3);
    }


    public static void showOptions() {
        System.out.println("O que você deseja fazer? (Insira o dígito):\n[1] - Calcular preço total.\n[2] - Calcular troco.\n[3] - Sair.");
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Apenas números inteiros são válidos.");
            scanner.nextLine();
        }
        switch (option) {
            case 1:
                showComputeTotalPriceOption();
                break;
            case 2:
                showComputeChangeOption();
                break;
            case 3:
                shutDown();
                break;
            default:
                System.out.println("Não foi possível reconhecer a entrada. Tente novamente");
                break;
        }
    }

    public static double getTotalPrice(int qtd, double price) {
        if (qtd < 0) {
            qtd *= -1;
        }
        return qtd * price;
    }

    public static void showComputeTotalPriceOption() {
        try {
            System.out.println("Insira a quantidade vendida do item: ");
            int qtd = scanner.nextInt();
            System.out.println("Insira o preço do item vendido: ");
            double price = scanner.nextDouble();
            System.out.printf("\nO valor total é de R$%.2f.\n", getTotalPrice(qtd, price));
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida, apenas números são aceitos.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static double getChange(double price, double given) throws Exception {
        if (price > given) {
            throw new Exception("O preço é maior do que o valor recebido pelo cliente.");
        }
        if (price == given) {
            return 0;
        }

        return given - price;
    }

    public static void showComputeChangeOption() {
        try {
            System.out.println("Insira o valor recebido pelo cliente: ");
            double receivedValue = scanner.nextDouble();
            System.out.println("Insira o preço do produto: ");
            double price = scanner.nextDouble();
            double change = getChange(price, receivedValue);
            System.out.printf("\nO troco é de R$%.2f.\n", change);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida, apenas números são aceitos.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void shutDown() {
        System.out.println("Adeus.");
        System.exit(0);
    }

}