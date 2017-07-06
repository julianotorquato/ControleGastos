package com.julianotorquato07.gastos.common.properties;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class PropertiesUtils {

    private static final String FILE_NAME = "message";

    private ResourceBundle bundle;
    private static PropertiesUtils instance;

    private PropertiesUtils() {
        this.bundle = ResourceBundle.getBundle(FILE_NAME);
    }

    private static PropertiesUtils getInstance() {
        if (instance == null) {
            instance = new PropertiesUtils();
        }
        return instance;
    }

    public static String getString(PropertiesKey key) {
        return getInstance().bundle.getString(key.toString());
    }

    public static String getString(PropertiesKey key, String... params) {
        MessageFormat formatter = new MessageFormat("");
        formatter.applyPattern(getInstance().bundle.getString(key.toString()));
        return formatter.format(params);
    }

}