package com.aggmoread.sdk.z.b.n;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f4740a;

    private a() {
    }

    private int a(int i10, int i11, int i12, int i13) {
        double min = Math.min(i10 / i12, i11 / i13);
        float f10 = 1.0f;
        while (true) {
            float f11 = 2.0f * f10;
            if (f11 > min) {
                return (int) f10;
            }
            f10 = f11;
        }
    }

    private int a(int i10, int i11, int i12, int i13, ImageView.ScaleType scaleType) {
        if (i10 == 0 && i11 == 0) {
            return i12;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i10 == 0 ? i12 : i10;
        }
        if (i10 == 0) {
            return (int) (i12 * (i11 / i13));
        }
        if (i11 == 0) {
            return i10;
        }
        double d10 = i13 / i12;
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d11 = i11;
            return ((double) i10) * d10 < d11 ? (int) (d11 / d10) : i10;
        }
        double d12 = i11;
        return ((double) i10) * d10 > d12 ? (int) (d12 / d10) : i10;
    }

    public Bitmap a(int i10, int i11, Bitmap.Config config, ImageView.ScaleType scaleType, byte[] bArr) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (i10 != 0 || i11 != 0) {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i12 = options.outWidth;
            int i13 = options.outHeight;
            int a10 = a(i10, i11, i12, i13, scaleType);
            int a11 = a(i11, i10, i13, i12, scaleType);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i12, i13, a10, a11);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray == null) {
                return decodeByteArray;
            }
            if (decodeByteArray.getWidth() <= a10 && decodeByteArray.getHeight() <= a11) {
                return decodeByteArray;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, a10, a11, true);
            decodeByteArray.recycle();
            return createScaledBitmap;
        }
        options.inPreferredConfig = config;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f4740a == null) {
                    synchronized (a.class) {
                        try {
                            if (f4740a == null) {
                                f4740a = new a();
                            }
                        } finally {
                        }
                    }
                }
                aVar = f4740a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }
}
