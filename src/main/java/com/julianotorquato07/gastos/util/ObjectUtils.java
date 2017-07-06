package com.julianotorquato07.gastos.util;

public class ObjectUtils {

    public static boolean isNotEmpty(Object objeto) {
        return !isEmpty(objeto);
    }
    
    public static boolean isEmpty(Object objeto) {
        return objeto == null || objeto.toString().trim().equals("") || objeto.toString().trim().equals(null);
    }

    public static boolean isZero(Object objeto) {
        return isEmpty(objeto) || objeto.toString().trim().equals("0") || objeto.toString().trim().equals(0.0);
    }
    
    
    
    
}
