package EDILSON_ALVES.primeirob.listas.listaum;

import java.util.Scanner;

public class Calculator {
    
  public static void main(String[] args) {
    int valorUm,valorDois,opcao;
    
    
    Scanner scan = new Scanner(System.in);
   do{ 
    System.out.println("[1] para calcular o preço total\n[2] para calcular o troco\n[33] para sair");
      opcao = scan.nextInt();

    if(opcao == 1){
      System.out.println("Digite um valor do produto");
        valorUm = scan.nextInt();
    
    System.out.println("Digite quantas unidade deste produto você deseja");
      valorDois = scan.nextInt();

  
      int soma = valorUm * valorDois;
      System.out.println("O valor total é: " + soma);
      
    }
    if(opcao == 2){
      System.out.println("valor que o cliente deu");
        valorUm = scan.nextInt();
      System.out.println("valor da compra");
        valorDois = scan.nextInt();

      int troco = valorUm - valorDois;

      System.out.println("O troco é: " + troco);

      
    }
   }while(opcao != 3);

   scan.close();
    
  }

}

