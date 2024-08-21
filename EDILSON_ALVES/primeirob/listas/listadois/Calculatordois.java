package EDILSON_ALVES.primeirob.listas.listadois;

import java.util.Scanner;

public class Calculatordois {
    
    
      public static void main(String[] args) {
        int[] vet = new int[10];  
        int valorUm, valorDois, opcao;
        Scanner scan = new Scanner(System.in);
    
        for (int i = 1; i < 6; i++) {
          System.out.println("[1] para calcular o preço total | [2] para calcular o troco | [0] sair");
          opcao = scan.nextInt();
    
          if (opcao == 0) {
            System.out.println("Saindo");
            break; 
          }
    
          switch (opcao) {
            case 1:
              System.out.println("Digite o valor do produto:");
              valorUm = scan.nextInt();
    
              System.out.println("Digite quantas unidades deste produto você deseja:");
              valorDois = scan.nextInt();
    
              int total;
              if (valorDois > 10) {
                int regra3 = valorDois * valorUm;
                int desconto = (regra3 * 5) / 100;
    
                total = regra3 - desconto;
                System.out.println("O valor do desconto de 5%: " + desconto + " e o valor total com desconto é: " + total);
                
              } else {
                total = valorUm * valorDois;
                System.out.println("O valor total é: " + total);
              }
              vet[i] = total;
              break;
    
            case 2:
              System.out.println("Digite o valor que o cliente deu:");
              valorUm = scan.nextInt();
              System.out.println("Digite o valor da compra:");
              valorDois = scan.nextInt();
    
              int troco = valorUm - valorDois;
              System.out.println("O troco é: " + troco);
              vet[i] = troco;
              break;
    
            default:
              System.out.println("Opção inválida. Tente novamente.");
          }
        }
        scan.close();
          for (int i = 1; i < 6; i++){
          System.out.println("O valor da compra "+ i +" é: " + vet[i]);
        }
      }
    }
    
    

