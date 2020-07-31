package com.wsw.util;

import java.math.BigDecimal;

/**
 * @author wensw
 */
public class MathUtil {

    /**
     * 计算双精度相加，防止精度丢失  第一个值加上第二个值
     *
     * @param v1 值1
     * @param v2 值2
     * @return v1-v2
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return get2Friction(b1.add(b2).doubleValue());
    }

    /**
     * 计算双精度相减，防止精度丢失  第一个值减去第二个值
     *
     * @param v1 值1
     * @param v2 值2
     * @return v1-v2
     */
    public static double minus(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return get2Friction(b1.subtract(b2).doubleValue());
    }

    //取小数点后二位
    private static double get2Friction(double inputDouble) {
        return (double) Math.round(inputDouble * 100) / 100;
    }
}
