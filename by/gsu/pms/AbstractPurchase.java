package by.gsu.pms;

public abstract class AbstractPurchase implements Comparable<Object>{

    private Commodity commodity;
    private int count;

    public AbstractPurchase(){

    }

    public AbstractPurchase(Commodity commodity, int count) {
        super();
        this.commodity = commodity;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }
    public abstract int getCost();

    protected String fieldsToString() {
        return commodity+";"+getCount();
    }
    @Override
    public String toString() {
        return fieldsToString()+';'+Convert.convertToByn(getCost(),100,2);

    }

    @Override
    public int compareTo(Object AbstractPurchase) {
        AbstractPurchase p = (AbstractPurchase) AbstractPurchase;
        if(getCost()<p.getCost()) return -1;
        else if (getCost()<p.getCost()) return 1;
        else return 0;
    }
}