package JOAO_VITOR_NOVAK_GAVA.primeirob.aulaum;

public class Registro {
    private final int quantidade;
    private final float total;
    private final boolean desconto;

    public Registro(int quantidade, float total, boolean desconto) {
        this.quantidade = quantidade;
        this.total = total;
        this.desconto = desconto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getTotal() {
        return total;
    }

    public boolean isDesconto() {
        return desconto;
    }

    @Override
    public String toString() {
        return quantidade + "," + total + "," + (desconto ? "Sim" : "Não");
    }
}
