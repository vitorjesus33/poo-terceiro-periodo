package domain.entities;

import domain.exceptions.ItemException;

import java.util.ArrayList;

public class Sale {

    private ArrayList<ItemsSale> itemsSaleList = new ArrayList<>();

    public double getGrossValue(){
        return this.itemsSaleList.stream()
                .mapToDouble( itemSale -> (itemSale.getItem().getPrice() * itemSale.getQuantity()) )
                .sum();
    }

    public double getNetValue(){
        double grossValue = this.getGrossValue();
        double discount = getTotalDiscountValue();
        return grossValue - discount;
    }

    public double getTotalDiscountValue(){
        return this.itemsSaleList.stream()
                .mapToDouble(ItemsSale::getDiscountValue)
                .sum();
    }

    public ArrayList<ItemsSale> getItemsSaleList() {
        return itemsSaleList;
    }

    public void addItem( Item item, int quantity ) throws ItemException {
        ItemsSale itemSale = new ItemsSale();
        itemSale.setItem(item);
        itemSale.setQuantity(quantity);
        if(quantity > 10) itemSale.setDiscount(5);

        this.itemsSaleList.add(itemSale);
    }

    public int getTotalQuantity(){
        return this.itemsSaleList.stream().mapToInt(ItemsSale::getQuantity).sum();
    }

}
