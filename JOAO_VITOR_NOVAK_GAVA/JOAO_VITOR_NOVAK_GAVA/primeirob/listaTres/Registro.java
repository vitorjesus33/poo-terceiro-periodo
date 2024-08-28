package JOAO_VITOR_NOVAK_GAVA.primeirob.listaTres;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Registro {
    private int quantidade;
    private float total;
    private boolean desconto;
    private LocalDateTime data;

    public Registro(int quantidade, float total, boolean desconto, LocalDateTime data) {
        this.quantidade = quantidade;
        this.total = total;
        this.desconto = desconto;
        this.data = data;
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

    public LocalDateTime getData() {
        return data;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return quantidade + "," + total + "," + (desconto ? "Sim" : "Não") + "," + data.format(formatter);
    }
}
