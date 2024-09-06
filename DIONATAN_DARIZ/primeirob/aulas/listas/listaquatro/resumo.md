Título

# Aprendendo md
## teste h2
### teste h3

Texto simples sem formatação, **negrito**.

Listas
- tópico um
- Dois
    - Teste

Links e imagens:



# ***Resumo Aula***

## **Markdown o que é**:

É uma linguagem de marcação simples, projetada para formatar texto de maneira rápida e eficiente, especialmente web. É possível adicionar formatações básicas, como negrito, itálico, títulos, listas, links e imagens, usando uma sintaxe leve e intuitiva.

## **Markdown Sintax Básicas**
![Slide Aula 5 POO Sintax Básica Markdown](https://github.com/user-attachments/assets/7eac975b-71b3-4d02-b6d5-afbf9157d1ca)

## ***- O que é Paradigma fora da programação?*** 
Um paradigma é um conjunto de práticas, teorias, crenças e padrões que define como um determinado grupo de pessoas compreende e organiza o conhecimento em um campo específico.  

## ***- Paradigmas da Programação:*** 
Conjunto de regras, princípios, conceitos de design que definem a aneira como o código do programa é escrito e organizado.

# ***ABORDAGENS***

### ***- Paradigma Imperativo:*** 
É dirigido por camadas. Direciona a execução do programa como uma sequência de instruções executadas uma a uma. Consiste em um conjunto de instruções, e cada declaração orientada o que deve ser feito e como deve ser feito.  

    
### ***Exemplos***
- **Estruturada**: Também é referida alternadamente como programação modular. Visa otimizar o código utilizando os bloco de fluos de controle do programa, blocos de tomada de decisão (if, if then, else). Buscar melhorar a legibilidade do código assim ajudando na reutilização do código. Estruturas são Cobol,PHP, Perl e Go.

 - **Exemplo Código PHP**
~~~php
// Função para calcular a média de uma lista de números
function calcular_media($numeros) {
    $soma = 0;
    $quantidade = count($numeros);

    // Somando todos os números na lista
    foreach ($numeros as $numero) {
        $soma += $numero;
    }

    // Calculando a média
    $media = $soma / $quantidade;
    return $media;
}

// Função para ler os números fornecidos pelo usuário
function ler_numeros() {
    $numeros = [];

    echo "Quantos números você deseja inserir? ";
    $quantidade = intval(trim(fgets(STDIN)));

    for ($i = 0; $i < $quantidade; $i++) {
        echo "Digite o número " . ($i + 1) . ": ";
        $numeros[] = floatval(trim(fgets(STDIN)));
    }

    return $numeros;
}

// Função principal para execução do programa
function main() {
    $numeros = ler_numeros();
    $media = calcular_media($numeros);

    echo "A média dos números fornecidos é: " . $media . PHP_EOL;
}

// Chamando a função principal
main();
~~~

- **Procedural**: Chamadas de procedimentos, em que as instruções são estruturadas em procedimentos (sub-rotinas ou funções). São uma lista de intruções para dizer ao computador o que fazer passo a passo. A maioria das primeiras linguagens são Procedurais como C, C++, Java e Pacal.

- **Exemplo Código Java**

~~~java
import java.util.Scanner;

        public class MediaNumeros {

    // Função para calcular a média de um array de números
    public static double calcularMedia(double[] numeros) {
        double soma = 0;

        // Somando todos os números no array
        for (int i = 0; i < numeros.length; i++) {
            soma += numeros[i];
        }

        // Calculando a média
        return soma / numeros.length;
    }

    // Função para ler os números fornecidos pelo usuário
    public static double[] lerNumeros() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos números você deseja inserir? ");
        int quantidade = scanner.nextInt();
        double[] numeros = new double[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            numeros[i] = scanner.nextDouble();
        }

        return numeros;
    }

    // Função principal para execução do programa
    public static void main(String[] args) {
        double[] numeros = lerNumeros();
        double media = calcularMedia(numeros);

        System.out.println("A média dos números fornecidos é: " + media);
    }
}
~~~

 
### ***- Paradigma Declarativos:*** 
Focado na lógica do progrmada em si, e no resultado. O fluxo de controle não é o elemento mais importate do programa e sim alcançar o resultado desejado.
### ***Exemplos***
- **Funcional:** Como o próprio nome já diz, "Funcões". Não existe uma lista de instruções ou abjetos para o computador realizar, mas um sequência de funções matemáticas que juntas vão resolver o problema. Linguagens (Haskell, Scala, JS e Clojure).
- **Exemplo código em JS**
~~~JS
// Função para calcular a soma de um array de números
const calcularSoma = numeros => numeros.reduce((acumulador, numero) => acumulador + numero, 0);

// Função para calcular a média de um array de números
const calcularMedia = numeros => calcularSoma(numeros) / numeros.length;

// Função para filtrar números positivos
const filtrarPositivos = numeros => numeros.filter(numero => numero > 0);

// Função principal para execução do programa
const main = () => {
    const numeros = [10, -5, 20, -3, 30];

    const numerosPositivos = filtrarPositivos(numeros);
    const media = calcularMedia(numerosPositivos);

    console.log("Números positivos: ", numerosPositivos);
    console.log("A média dos números positivos é: " + media);
};

// Executando a função principal
main();
~~~


- **Lógica:** a lógica define o que deve ser resolvido enquanto o controle define como deve ser resolvido. O programador pode escolher qual parte do problema quer resolver e assim o sistema vai achar a melhor maneira para resolver ele. O foco está em declarar fatos e regras que possam ser utilizados para iferir novas informações e soluções. Linguagens (Prolog e DataLog)

- **Exemplo código em Prolog:**
~~~prolog
% Fatos: Definindo quem são os pais de quem
pai(jose, ana).
pai(jose, carlos).
pai(carlos, maria).
mae(maria, joao).

% Regra: Definindo quem é pai/mãe de alguém
pai_de(X, Y) :- pai(X, Y).
mae_de(X, Y) :- mae(X, Y).

% Regra: Definindo quem é filho de alguém
filho_de(X, Y) :- pai(Y, X).
filho_de(X, Y) :- mae(Y, X).

% Regra: Definindo ancestralidade
ancestral_de(X, Y) :- pai(X, Y).
ancestral_de(X, Y) :- mae(X, Y).
ancestral_de(X, Y) :- pai(X, Z), ancestral_de(Z, Y).
ancestral_de(X, Y) :- mae(X, Z), ancestral_de(Z, Y).

% Consultas:
% Quem é pai de Ana?
% ?- pai_de(jose, ana).

% Quem são os ancestrais de Maria?
% ?- ancestral_de(X, maria).
~~~

# **Exemplo em Imagem**
![Slide Aula 5 POO](https://github.com/user-attachments/assets/62b6ad1e-d655-41c6-adb1-8737f69943ce)

# **Conceito em Imagem**
![Slide Aula 5 POO CONCEITO](https://github.com/user-attachments/assets/ebeec74f-47fa-4b3b-aaf0-f8ba16aabea7)



# ***Programação Oritentada a Objeto***

Criada na década de 1970 por Alan Kay, a programação orientada a objetos como seu nome já diz, se baseia na criação de objetos que possuem propriedade e métodos, permitindo o encapsulamento de dados e a reutilização no código. Linguagens (PHP, Java, C#, JS, Python e Ruby).
- ## **Pilares:**
    - **Herança:** criação de novas classes com base em classes existentes.
    - **Polimorfismo:** trate-se da capacidade de um objeto se passar por outro compatível.
    - **Encapsulamento:** gerenciamento do acesso a atributos e métodos.
    - **Abstração:** representação de conceitos essenciais do mundo real.

- ## **Benefícios:**
    - **Reutilização de código:** permite aproveitar classes e objetos existentes.
    - **Modularidade:** incentiva a divisão do código em módulos independentes.
    - **Flexibilidade e escalabilidade:** oferece flexibilidade no design do software, permitindo adicionar novas funcionalidades e modificar o comportamento dos objetos sem afetar outras partes do sistema.
    - **Organização e coesão do código:** o código se torna mais organizado e coeso. Através da encapsulação e abstração, a lógica de programação é estruturada de maneira clara e compreensível.


### **Java**
    -Multiparadigma
    -Procedural
    -Estruturado
    -POO
    -Programação concorrente
    -Funcional(A partir do Java 8*)



### **Conclusão**

- **Paradigmas Imperativos:** foco em como executar, define o fluo de controle que altera o estado do programa.
Exemplo: Procedural, Estruturado e POO.

- **Paradigmas Declarativos:** foco em o que executar, define a lógica do programa, mas não em um fluxo de controle detalhada. 
Exemplo: Funcional e Lógico.

