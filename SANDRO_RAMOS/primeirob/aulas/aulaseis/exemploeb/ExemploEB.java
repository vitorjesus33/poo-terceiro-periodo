package primeirob.aulas.aulaseis.exemploeb;

import java.util.Date;

public class ExemploEB {
    
    public static void main(String[] args) {
        
        Soldado soldadoUm = new Soldado();
        Soldado soldadoDois = new Soldado();
        
        Sargento sargentoDeDia = new Sargento();

        sargentoDeDia.nome = "Magagnin";
        sargentoDeDia.anoFormacao = new Date(113, 10, 01);
        sargentoDeDia.compania = "CCAP";
        sargentoDeDia.isAntigo = true;
        sargentoDeDia.realizouCas = true;

        EscalaServico escalaServicoSegunda = new EscalaServico();
        EscalaServico escalaServicoTerca = new EscalaServico();

        soldadoUm.nome = "Alexandre";
        soldadoUm.compania = "1º";
        soldadoUm.isAntigo = true;

        soldadoDois.nome = "Ramos";
        soldadoDois.compania = "CCAP";
        soldadoDois.isAntigo = true;

        escalaServicoSegunda.guarnicao.add(soldadoDois);
        escalaServicoSegunda.guarnicao.add(sargentoDeDia);
        escalaServicoSegunda.dataServico = new Date();
        
        escalaServicoTerca.guarnicao.add(soldadoUm);
        escalaServicoTerca.guarnicao.add(sargentoDeDia);
        escalaServicoTerca.dataServico = new Date();

    }

}
