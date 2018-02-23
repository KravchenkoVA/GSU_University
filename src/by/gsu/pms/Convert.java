package by.gsu.pms;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Convert {
    public static String convertToByn(int param, int divider, int scale) {
        BigDecimal bd = new BigDecimal(param);
        BigDecimal result = bd.divide(new BigDecimal(divider));
        result = result.setScale(scale, RoundingMode.CEILING);
        return result.toString();
    }

}