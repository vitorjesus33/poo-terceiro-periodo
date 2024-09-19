package primeirob.aulas.aulacinco;

public class NinjaTest {
    
    public static void main(String[] args) {
        
        Ninja ninjaUm = new Ninja();
        Ninja ninjaDois = new Ninja();

        String nomeIncorreto = "Naruto123";

        ninjaUm.name = StringUtils.removeNumeros(nomeIncorreto);
        ninjaUm.aldeia = "Folha";
        ninjaUm.cla = "Uzumaki";
        ninjaUm.idade = 20;
        ninjaUm.nomeJutso = "Rasengan";
        ninjaUm.equipamento = "Shuriken";

        ninjaDois.name = "Sasuke";
        ninjaDois.aldeia = "Folha";
        ninjaDois.cla = "Uchiha";
        ninjaDois.idade = 18;
        ninjaDois.nomeJutso = "Chidori";
        ninjaDois.equipamento = "Shuriken";

        ninjaUm.apresentarse();
        ninjaUm.realizarJutso();

        ninjaDois.apresentarse();
        ninjaDois.realizarJutso();
    }

}
