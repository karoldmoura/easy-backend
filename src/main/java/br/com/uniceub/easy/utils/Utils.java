package br.com.uniceub.easy.utils;

import java.util.Collection;

public class Utils {

    public static boolean isNullOrEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }
}
