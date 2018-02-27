package by.gsu.pms;
import java.util.Comparator;

public class NameComparator implements Comparator<Patient>
{
    public int compare(Patient o1, Patient o2)
    {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}