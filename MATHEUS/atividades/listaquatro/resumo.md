# Paradigma de programação
### significado de paradigma
Paradigma é descrito nos dicionários como um substantivo masculino que significa exemplo geral, conjunto de formas ou modelo de algo. Na linguagem coloquial é constantemente utilizada como sinônimo de padrão, exemplo, modelo, norma, protótipo e regra.

## Paradigma imperativo
- ### Programação Estruturada.
    - A programação estruturada tem como seu princpal objetivo otimizar o Código utilizandoblocos de fluxo de controle do programa.<br> 
    <br>
     **Pascal**: Desenvolvida para ensino e pesquisa, Pascal é uma linguagem que promove a programação estruturada e é conhecida por sua sintaxe clara e bem definida.<br>
     **exemplo de codigo em pascal**:
    
        ~~~pascal
            program SomaDeInteiros;

            var
            i, soma: integer;

            begin
                soma := 0;
        
            // Loop para somar os números de 1 a 10
            for i := 1 to 10 do
                soma := soma + i;
        
            // Imprime o resultado
            writeln('A soma dos números de 1 a 10 é: ', soma);
        
            end.
    
- ### Programação Procedural.
    -  De forma geral a programação procedural também é uma programação estruturada, como uma evoulção da cracteristica de modularização da programação estruturada, mas ainda não é uma programação modular, como a programação orientada a objetos
- ### Programação Orientada a Objetos.
  - Programação orientada a objetos é um dos paradimas mais ultilizados na atualidade, ela permite abstrair as estruturas de dados utilizando objestos e classes, facilitando o programador a reutilizar códigos e modularizar a programação
## Paradigma declarativo
- ### Programação Funcional
  - é o paradigma da programação que se concentrea em resolver equações matematicas. Ela trata a computação como a avaliação de funções e evita o uso de estados mutáveis e dados compartilhados. parte do principio que tudo são funções parte do principio em que o computador tem uma sequencia de funçoes matematica para resolver e elas, comprirão a resolução de um problema
- ### Programação Lógica
    - neste paradigma o principal foco é a definição do probelma e deixar o sistema decidir como resolver esse problema, o trabalho principal e definir qual é o problema a ser resolvido. e deixar o sistema escolher qual a menlhor forma para resolver o probelma, em resumo se preocupa com oque e não com o como, um exemplo disso são os arrays de java script que são listas e não arrays
