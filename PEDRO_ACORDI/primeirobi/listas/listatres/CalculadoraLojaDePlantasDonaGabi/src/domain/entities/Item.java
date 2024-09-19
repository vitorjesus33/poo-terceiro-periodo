package domain.entities;

import domain.exceptions.ItemException;

public class Item {

    private double price;

    public Item(double price) throws ItemException {
        this.setPrice(price);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws ItemException {
        if(price <= 0) throw new ItemException("Preço não pode ser menor ou igual a zero.");
        this.price = price;
    }
}
