package com.example.boluouitest2.util;

public class NumberUtil {

    /* renamed from: a */
    public static String m9066a(String str, int i) {
        double doubleValue = Double.valueOf(str).doubleValue();
        if (doubleValue >= 1.0E8d) {
            double d = doubleValue / 1.0E8d;
            if (i == 1) {
                return String.format("%.2f", Double.valueOf(d)) + "亿";
            }
            return String.format("%.2f", Double.valueOf(d)) + "y";
        } else if (doubleValue >= 10000.0d) {
            double d2 = doubleValue / 10000.0d;
            if (i == 1) {
                return String.format("%.2f", Double.valueOf(d2)) + "万";
            }
            return String.format("%.2f", Double.valueOf(d2)) + "w";
        } else if (doubleValue >= 1000.0d) {
            double d3 = doubleValue / 1000.0d;
            if (i == 1) {
                return String.format("%.2f", Double.valueOf(d3)) + "千";
            }
            return String.format("%.2f", Double.valueOf(d3)) + "k";
        } else {
            return ((int) doubleValue) + "";
        }
    }

    /* renamed from: a */
    public static String m9067a(int i, int i2) {
        return m9066a(String.valueOf(Math.max(i, 0)), i2);
    }

}
