package br.com.alura.aluraviagens.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourceUtil {
    @SuppressLint("UseCompatLoadingForDrawables")
    public static Drawable getDrawable(Context context, String imagem) {
        Resources resources = context.getResources();
        @SuppressLint("DiscouragedApi")
        int idDrawable = resources.getIdentifier(imagem,
                "drawable", context.getPackageName());
        return resources.getDrawable(idDrawable);
    }
}
