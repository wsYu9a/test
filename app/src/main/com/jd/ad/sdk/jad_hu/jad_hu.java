package com.jd.ad.sdk.jad_hu;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* loaded from: classes2.dex */
public class jad_hu {
    public static Bitmap jad_an(Bitmap bitmap, int i10, int i11) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i10 / width, i11 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
