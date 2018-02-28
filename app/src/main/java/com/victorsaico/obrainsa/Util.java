package com.victorsaico.obrainsa;

import android.graphics.Bitmap;
import android.util.Base64;
import android.util.DisplayMetrics;

import java.io.ByteArrayOutputStream;

import static com.victorsaico.obrainsa.Obrainsa.getAppContext;

/**
 * Created by JARVIS on 25/02/2018.
 */

public class Util {
    public static int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getAppContext().getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.densityDpi / 160.0F));
    }
    public static String bitmapToBase64Jpge(Bitmap bmp) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT).replace("\n", "").replace("\r", "");
    }
}
