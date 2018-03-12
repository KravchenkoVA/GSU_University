import by.gsu.pms.Human;
import by.gsu.pms.HumanChild;
import by.gsu.pms.HumanParent;
import by.gsu.pms.HumanTeenager;
public class Runner {
    public static void main(String[] args) {
            Human[] p = {
                    new Human("Kravchenko Vladimir Andreevich", 'm',20),
                    new Human("Kovalev Aleksandr Yurievich",'m'),
                    new HumanChild("Petrov Aleksandr Fedorovich", 'm',6,17 ),
                    new HumanChild("Ivanova Olga Alekseevna", 'w', 5),
                    new HumanTeenager("Sidorova Alina Victorovna", 'w',12,18,9.2),
                    new HumanTeenager("Sidorova Alina Victorovna", 'w',16,18),
                    new HumanParent("Karaban Aleksei Vladimirovich",'m',42,7,"BMZ"),
                    null,
                    new HumanParent("Antonenko Anton Andreevich",'m',28,2)
            };
            for (int i=0;i<p.length;i++){
                System.out.println(p[i]);
            }
    }
}