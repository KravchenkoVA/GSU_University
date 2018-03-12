package by.gsu.pms;

public class PurchaseDiscountPrice extends AbstractPurchase {

    private int discount;

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public PurchaseDiscountPrice() {
    }

    public PurchaseDiscountPrice(Commodity commodity, int count, int discount) {
        super(commodity,count);
        this.discount = discount;
    }
    @Override
    public int getCost() {
        return (getCommodity().getPrice()-discount)*getCount();
    }
    @Override
    public String toString() {
        return fieldsToString()+';'+Convert.convertToByn(discount,100,2)+';'+Convert.convertToByn(getCost(),100,2);

    }



}