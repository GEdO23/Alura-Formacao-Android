package br.com.alura.aluraviagens.util;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    private static final String DATE_FORMAT = "dd/MM";

    @NonNull
    public static String format(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        String dataFormatadaIda = dateFormat.format(dataIda.getTime());
        String dataFormatadaVolta = dateFormat.format(dataVolta.getTime());

        return dataFormatadaIda + " - " +
                dataFormatadaVolta + " de " +
                dataVolta.get(Calendar.YEAR);
    }
}
