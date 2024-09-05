package ALEX_HOFFMANN.primeirob.listas.lista2;

public class RegistroDeVendas {

        private int quantidadeVendida;
        private double valorVenda;
        private double desconto;

        public RegistroDeVendas(int quantidadeVendida, double valorVenda, double desconto) {
            this.quantidadeVendida = quantidadeVendida;
            this.valorVenda = valorVenda;
            this.desconto = desconto;
        }

        public int getQuantidadeVendida() {
            return quantidadeVendida;
        }

        public double getValorVenda() {
            return valorVenda;
        }

        public double getDesconto() {
            return desconto;
        }
}
