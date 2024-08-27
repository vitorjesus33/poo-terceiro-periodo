package ERICK_SCUR.primeirob.listas.lista3;

class Venda {
    private int quantidade;
    private double precoUnitario;
    private double valorTotal;

    public Venda(int quantidade, double precoUnitario, double valorTotal) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.valorTotal = valorTotal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Quantidade: " + quantidade + ", Preço unitário: R$ " + precoUnitario + ", Valor total: R$ " + valorTotal;
    }
}
