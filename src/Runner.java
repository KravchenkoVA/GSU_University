import by.gsu.pms.Subject;
import by.gsu.pms.Material;

public class Runner {
    public static void main(String[] args)
    {
        Material p = new Material("Steel",7850);
        Subject z = new Subject("wire", p, 0.03);
        System.out.println(z);
        Material q = new Material("Cooper", 8500);
        Subject x = new Subject("wire", q, 0.03);
        System.out.println(x.getMass());
        System.out.println(x);
    }
}
