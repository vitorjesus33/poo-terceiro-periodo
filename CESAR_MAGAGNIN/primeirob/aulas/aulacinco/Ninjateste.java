package CESAR_MAGAGNIN.primeirob.aulas.aulacinco;

public class Ninjateste {
    public static void main(String[]args){
        Ninja ninjaUm = new Ninja();
        Ninja ninjaDois = new Ninja();

        ninjaUm.nome = "Jaba";
        ninjaUm.aldeia = "Arataca";
        ninjaUm.cla = "Nordeste";
        ninjaUm.equipamento = "Peixeira";
        ninjaUm.nomeJutso = "Facada";
        ninjaUm.idade = 19;
        
        ninjaDois.nome = "Gaúcho";
        ninjaDois.aldeia = "Pampas";
        ninjaDois.cla = "Sul";
        ninjaDois.equipamento = "Garumcha";
        ninjaDois.nomeJutso = "Tiro";
        ninjaDois.idade = 19;

        ninjaUm.apresentarse();
        ninjaUm.realizarJutso();
        ninjaDois.apresentarse();
        ninjaDois.realizarJutso();
    }
}
