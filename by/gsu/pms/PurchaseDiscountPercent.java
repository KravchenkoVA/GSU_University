package by.gsu.pms;

public class PurchaseDiscountPercent extends AbstractPurchase {

    private double percent;

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public PurchaseDiscountPercent() {
    }

    public PurchaseDiscountPercent(Commodity commodity, int count, int percent) {
        super(commodity,count);
        this.percent = percent;
    }
    @Override
    public int getCost() {
       return (int)Math.round(getCommodity().getPrice()*getCount()*(1-percent/100));
        }

    @Override
    public String toString() {
        return fieldsToString()+';'+percent+';'+Convert.convertToByn(getCost(),100,2);

    }

}