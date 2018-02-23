import by.gsu.pms.Convert;
import by.gsu.pms.Purchase;
import by.gsu.pms.WeekDays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
                    Purchase[] p = { new Purchase(2,WeekDays.Mon),
                            new Purchase(8, WeekDays.Fri),
                            new Purchase(12, WeekDays.Sat),
                            new Purchase(7, WeekDays.Mon),
                            new Purchase(4, WeekDays.Tue)
                    };
        System.out.println("Product: "+Purchase.PRODUCT+"; "+"Product Price: "+Purchase.PRODUCT_PRICE+';');
       int middlePurchase=0;
       int mondayPurchase=0;
       Purchase maxPur=p[0];
        for (int i=0;i<p.length;i++){
            System.out.println(p[i].toString());
            middlePurchase+=p[i].getCost();
            if (p[i].getWeekDay()==WeekDays.Mon){
                mondayPurchase+=p[i].getCost();
            }
            if (maxPur.getCost() < p[i].getCost())
            {
                maxPur = p[i];
            }
        }
        System.out.println("Middle: "+Convert.convertToByn(middlePurchase/p.length,100,2));
        System.out.println("Monday: "+Convert.convertToByn(mondayPurchase,100,2));
        System.out.println("Big Day: "+maxPur.getWeekDay());
        Arrays.sort(p);
        System.out.println("Сортировка: "+"\n"+"Product: "+Purchase.PRODUCT+"; "+"Product Price: "+Purchase.PRODUCT_PRICE+';');
        for (int i=0;i<p.length;i++){
            System.out.println(p[i].toString());
        }
    }
            }
