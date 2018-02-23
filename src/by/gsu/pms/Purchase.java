package by.gsu.pms;

public class Purchase implements Comparable<Purchase> {

    public final static String PRODUCT="history";
    public final static int PRODUCT_PRICE = 100 ;
    private int units;
    private WeekDays weekDay;
    public Purchase() {

    }
    public Purchase(int units, WeekDays weekDay) {
        this.units=units;
        this.weekDay=weekDay;

    }
    public Purchase(int units, int weekDay) {
        this(units,WeekDays.values()[weekDay]);
    }
    public int getUnits() {
        return units;
    }
    public void setUnits(int units) {
        this.units = units;
    }
    public WeekDays getWeekDay() {
        return weekDay;
    }
    public void setWeekDay(WeekDays weekDay) {
        this.weekDay = weekDay;
    }
    public int getCost(){
        double total;
        total=PRODUCT_PRICE*units;
        return (int) total ;
    }
    @Override
    public String toString() {
        return units + ";"+weekDay+";"+Convert.convertToByn(getCost(), 100, 2);
    }
    public int compareTo(Purchase arg) {
        return 0;
    }


}