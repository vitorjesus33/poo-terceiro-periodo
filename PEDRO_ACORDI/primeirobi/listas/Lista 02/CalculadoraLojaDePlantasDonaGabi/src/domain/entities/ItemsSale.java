package domain.entities;

import domain.exceptions.ItemException;

public class ItemsSale {

    private Item item;
    private int quantity;
    private double discount;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getDiscount() {
        return discount;
    }

    public double getDiscountValue(){
        return (this.item.getPrice()*this.quantity) * ( this.discount / 100 );
    }

    public void setDiscount(double discount) throws ItemException {
        if(discount < 0) throw new ItemException("O desconto não pode ser negativo");
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) throws ItemException {
        if(quantity <= 0) throw new ItemException("A quantidade deve ser maior ou igual a zero");
        this.quantity = quantity;
    }
}
