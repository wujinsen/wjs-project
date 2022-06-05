package cn.wjs;

import java.math.BigDecimal;

public class test {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(3.5);

       // BigDecimal bigDecimal1 = bigDecimal.doubleValue(0.01D);
        System.out.println(bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP));
    }
}
