import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

import by.gsu.pms.Product;
import by.gsu.pms.ProductFactory;


public class Runner {

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("src/in.txt"));
            sc.useLocale(Locale.ENGLISH);
            final int PRODUCT_NUMBER=6;
            int costProduct = 0;
            int maxCost= 0;
            boolean isEqual = true;
            Product maxProduct = new Product();
            Product[] products=new Product[PRODUCT_NUMBER];

            for (int i = 0; i < products.length; i++) {
                products[i]=ProductFactory.getProductFromFactory(sc);
                System.out.println( products[i]);
                costProduct= products[i].getCost();
                if((costProduct-maxCost)>0) {
                    maxCost=costProduct;
                    maxProduct=products[i];
                }
                if (isEqual){
                    isEqual=products[i].equals(products[0]);
                }
            }
            System.out.println();
            System.out.println("Purchase with maximum cost: "+maxProduct);
            System.out.println(isEqual? "Purchases are equal" : "Purchases are not equal");
        }
        catch (NoSuchElementException e) {
            System.err.println("Array of unacceptable length");
        }
        catch (NegativeArraySizeException e) {
            System.err.println("Array of unacceptable length");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid WeekDay in array");
        }
        catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }


        finally {
            if(sc != null) {
                sc.close();
            }
        }
}
}
