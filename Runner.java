import by.gsu.pms.PurchaseExpens;
import by.gsu.pms.PurchaseDiscountPercent;
import by.gsu.pms.PurchaseDiscountPrice;
import by.gsu.pms.AbstractPurchase;
import by.gsu.pms.Commodity;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args)
    {
        Commodity book=new Commodity("Book",3000);
        AbstractPurchase[] p = {new PurchaseDiscountPrice(book,5,500),
                                new PurchaseDiscountPrice(book,8,350),
                                new PurchaseDiscountPercent(book,3,10),
                                new PurchaseDiscountPercent(book,3,7),
                                new PurchaseExpens(book,10,200),
                                new PurchaseExpens(book,20,500)
        };
        for (int i=0;i<p.length;i++){
            System.out.println(p[i]);
        }
        Arrays.sort(p);
        System.out.println();
        System.out.println("After Sort: ");
        for (int i=0;i<p.length;i++){
            System.out.println(p[i]);
        }
        System.out.println();
        System.out.println("minimum cost: ");
        System.out.println(p[0]);
    }
}
