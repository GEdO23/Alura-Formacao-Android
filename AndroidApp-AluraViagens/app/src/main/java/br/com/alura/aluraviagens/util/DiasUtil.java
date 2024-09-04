package br.com.alura.aluraviagens.util;

import androidx.annotation.NonNull;

public class DiasUtil {

    private static final String PLURAL = " dias";
    private static final String SINGULAR = " dia";

    @NonNull
    public static String format(int dias) {
        return dias + (dias > 1 ? PLURAL : SINGULAR);
    }
}
