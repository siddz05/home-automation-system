package com.signz.homeautomation.utility;

/**
 * @author siddharthdwivedi
 */
public class Utility {

    public static <T> void print(T t) {
        System.out.print(t);
    }

    public static <T> boolean isNull(T t) {
        return t == null;
    }
}
