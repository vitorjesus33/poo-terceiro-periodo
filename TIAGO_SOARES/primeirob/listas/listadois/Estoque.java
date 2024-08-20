package primeirob.listas.listadois;

import java.util.Scanner;
import java.util.ArrayList;


public class Estoque {

    public static class Sales {
        int countPlant;
        double valuePerPlant;
        double totalBuy;
        double discount;
        double totalDiscount;

        public Sales(int countPlant, double valuePerPlant, double totalBuy, double discount, double totalDiscount){
            this.countPlant = countPlant;
            this.valuePerPlant = valuePerPlant;
            this.totalBuy = totalBuy;
            this.discount = discount;
            this.totalDiscount = totalDiscount;
        }
    }

    private static int choice;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<Sales> salesList = new ArrayList<>();

        do{
            System.out.println("====== Menu ======\n[1]Calcular Preço c/ Desconto\n[2]Registro de Vendas\n[3]Sair\n====== ==== ======");
            System.out.print("(Usuario): ");
            choice = reader.nextInt();

            switch (choice) {
                case 1:
                    clearConsole();
                    System.out.println("(Sistema) Calcular Preço com Desconto");
                    System.out.println("(Sistema) Caso o Cliente compre mais de 10 plantas, haverá um desconto de 5% no valor!\n");

                    System.out.println("(Sistema) Informe a quantidade plantas a serem compradas!");
                    System.out.print("(Usuario): ");
                    int countPlan = reader.nextInt();
                    
                    if(countPlan <= 0){
                        System.out.println("A Quantidade informada nao e valida!");
                    }else{
                        System.out.println("(Sistema) Informe o preço de cada planta!");
                        System.out.print("(Usuario): R$ ");
                        double valuePerPlan = reader.nextDouble();
                        if (countPlan > 10) {
                            clearConsole();
                            System.out.println("A quantidade da compra foi maior que 10! \n");
                            System.out.println("====== Venda ====== ");
                            double totalBuy = countPlan * valuePerPlan;
                            double discount = totalBuy * 0.05f;
                            System.out.printf("Total da Compra: R$%.2f%n", totalBuy);
                            System.out.printf("Desconto atribuido: R$%.2f%n", discount);
                            System.out.printf("Total com Desconto: R$%.2f%n", totalBuy - discount);
                            System.out.println("====== ===== ====== \n\n");

                            double totalDiscount = totalBuy - discount;

                            Sales actualSales = new Sales(countPlan, valuePerPlan, totalBuy, discount, totalDiscount);

                            salesList.add(actualSales);
                        } else {
                            clearConsole();
                            System.out.println("A quantidade da compra nao foi maior que 10! \n");
                            System.out.println("====== Venda ====== ");
                            System.out.printf("Total da Compra: R$%.2f%n", countPlan * valuePerPlan);
                            System.out.println("====== ===== ====== \n\n");
                        }
                    }

                break;
                case 2:
                    System.out.println("Registro de Vendas!\n");

                    if(salesList.size() == 0){
                        System.out.println("Nenhuma Venda encontrada! :( \n");
                    }else{
                        salesList.forEach(sale -> {
                            System.out.println("====== Venda N°"+ (salesList.indexOf(sale) + 1) + " ====== ");
                            System.out.println("Quatidade de Plantas: " + sale.countPlant);
                            System.out.printf("Valor por Plantas: R$%.2f%n", sale.valuePerPlant);
                            System.out.printf("Total da Compra: R$%.2f%n", sale.totalBuy);
                            System.out.printf("Desconto Aplicado: R$%.2f%n", sale.discount);
                            System.out.printf("Total com Desconto: R$%.2f%n", sale.totalDiscount);
                            System.out.println("====== ===== ====== \n");
                        });
                    }
                    
                    break;
                default:
                    break;
            }
        }while(choice != 3);
        reader.close();
        
    }

    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
