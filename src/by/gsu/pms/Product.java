package by.gsu.pms;
import java.util.Scanner;

public class Product{
    private String name;
    private int price;
    private int units;
    public Product() {

    }

    public Product(String name, int price, int units) {
        super();
        this.name = name;
        this.price = price;
        this.units = units;
    }
    public Product(Scanner sc) {
        this.name=sc.next();
        this.price=sc.nextInt();
        this.units=sc.nextInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
    public int getCost()
    {
        return (units * price);
    }
    @Override
    public  String toString() {
        return (name + ';' + Convert.convertToByn(price,100,2) + ',' + units + ';' + Convert.convertToByn(getCost(),100,2));
    }
    protected String fieldsToString() {
        return name+";"+Convert.convertToByn(price,100,2)+";"+units;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Product other = (Product) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (price == 0) {
            if (other.price != 0)
                return false;
        } else if (price==other.price)
            return false;
        return true;
    }


}