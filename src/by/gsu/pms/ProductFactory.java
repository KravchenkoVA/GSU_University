package by.gsu.pms;
import java.util.Scanner;
public class ProductFactory {
    private static enum ProductKind {
        GENERAL_PRODUCT {
            Product getProduct(Scanner sc) {
                return new Product(sc);
            }
        },
        DISCOUNT_PRODUCT {
            DiscountProduct getProduct(Scanner sc) {
                return new DiscountProduct(sc);
            }
        },
        PERSENT_PRODUCT{
            PersentProduct getProduct(Scanner sc) {
                return new PersentProduct(sc);
            }
        };
        abstract Product getProduct(Scanner sc);

    }
    public static Product getProductFromFactory(Scanner sc) {
        return ProductKind.valueOf(sc.next()).getProduct(sc);

    }

}

