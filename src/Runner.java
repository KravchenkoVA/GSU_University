import by.gsu.pms.NameComparator;
import by.gsu.pms.Patient;
import by.gsu.pms.AgeComparator;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Patient[] p = { new Patient("Kovalev",'m',20),
                        new Patient("Gladchenko",'w',19),
                        new Patient("Sereda",'m',12),
                        new Patient("Potapenok",'w',26),
                        new Patient("Afonina",'w',46),
                        new Patient("Kovaleva",'w'),
                        new Patient("Sinugin",'m',11),
                        new Patient("Kuchin",'m',22),
                        new Patient("Samburskaya",'w',36),
                        new Patient("Telegin",'m')
        };
        int countWomen=0;
        double middleAge=0;
        System.out.println("Not Sort: ");
        for (int i=0;i<p.length;i++)
        {
            System.out.println(p[i]);
            middleAge+=p[i].getAge();
            if (p[i].getSex()=='w'){
                countWomen++;
            }
        }
        Arrays.sort(p, new NameComparator());
        System.out.println();
        System.out.println("Sort by Name: ");
        for (int i=0;i<p.length;i++)
        {
            System.out.println(p[i]);
        }
        Arrays.sort(p, new AgeComparator());
        System.out.println();
        System.out.println("Sort by age: ");
        for (int i=0;i<p.length;i++)
        {
            System.out.println(p[i]);
        }
        System.out.println();
        System.out.println("Middle age= "+middleAge/p.length);
        System.out.println("Count Women= "+countWomen);

}
}
