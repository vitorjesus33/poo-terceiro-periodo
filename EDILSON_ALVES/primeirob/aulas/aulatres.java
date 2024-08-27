package EDILSON_ALVES.primeirob.aulas;

 class aulatres{
    public static void main(String [] args){

    int[][] matriz1 = {{31,27,4},{44,32,95},{9,16,56}};
    int[][] matriz2 = {{10,88,12},{38,32,73},{14,21,52}};
    double somar = 0, total = 0;
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1.length; j++) {
                somar = matriz1[i][j] + matriz2[i][j];
                total += somar;
            }
        }
        System.out.println(total);    
    };
}
 