package by.gsu.pms;

import by.gsu.pms.Convert;
import by.gsu.pms.Product;
import java.util.Scanner;

public class DiscountProduct extends Product {
    private int discount;

    public DiscountProduct(String name, int price, int units,int discount) {
        super(name,price,units);
        this.discount = discount;
    }

    public DiscountProduct(Scanner sc) {
        super(sc);
        this.discount = sc.nextInt();

    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public int getCost() {
        return (getPrice()-getDiscount())*getUnits();
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString()+";"+Convert.convertToByn(discount,100,2);
    }

    @Override
    public String toString() {
        return fieldsToString()+";"+ Convert.convertToByn(getCost(),100,2);
    }




}