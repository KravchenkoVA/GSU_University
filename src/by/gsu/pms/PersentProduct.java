package by.gsu.pms;

import java.util.Scanner;

public class PersentProduct extends Product {

    private double percent;
    private final static int LIMIT=10;

    public PersentProduct(String name, int price, int unit, double percent) {
        super(name,price,unit);
        this.percent = percent;
    }
    public PersentProduct(Scanner sc) {
        super(sc);
        this.percent=sc.nextInt();
    }


    public double getPersent() {
        return percent;
    }

    public void setPersent(double percent) {
        this.percent = percent;
    }

    @Override
    public int getCost() {
        int cost= super.getCost();
        if(getUnits()>LIMIT){
            cost =(int)Math.round(cost*(1-percent/100));
            return cost;
        }
        return super.getCost();
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString()+";"+percent+"%";
    }

    @Override
    public String toString() {
        return fieldsToString()+";"+Convert.convertToByn(getCost(),100,2);
    }

}