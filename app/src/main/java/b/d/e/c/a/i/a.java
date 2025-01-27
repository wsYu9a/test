package b.d.e.c.a.i;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f4639a;

    private a() {
    }

    private int a(int i2, int i3, int i4, int i5) {
        double d2 = i2;
        double d3 = i4;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = i3;
        double d5 = i5;
        Double.isNaN(d4);
        Double.isNaN(d5);
        double min = Math.min(d2 / d3, d4 / d5);
        float f2 = 1.0f;
        while (true) {
            float f3 = 2.0f * f2;
            if (f3 > min) {
                return (int) f2;
            }
            f2 = f3;
        }
    }

    private int b(int i2, int i3, int i4, int i5, ImageView.ScaleType scaleType) {
        if (i2 == 0 && i3 == 0) {
            return i4;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i2 == 0 ? i4 : i2;
        }
        if (i2 == 0) {
            double d2 = i3;
            double d3 = i5;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = i4;
            Double.isNaN(d4);
            return (int) (d4 * (d2 / d3));
        }
        if (i3 == 0) {
            return i2;
        }
        double d5 = i5;
        double d6 = i4;
        Double.isNaN(d5);
        Double.isNaN(d6);
        double d7 = d5 / d6;
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d8 = i2;
            Double.isNaN(d8);
            double d9 = i3;
            if (d8 * d7 >= d9) {
                return i2;
            }
            Double.isNaN(d9);
            return (int) (d9 / d7);
        }
        double d10 = i2;
        Double.isNaN(d10);
        double d11 = i3;
        if (d10 * d7 <= d11) {
            return i2;
        }
        Double.isNaN(d11);
        return (int) (d11 / d7);
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (f4639a == null) {
                synchronized (a.class) {
                    if (f4639a == null) {
                        f4639a = new a();
                    }
                }
            }
            aVar = f4639a;
        }
        return aVar;
    }

    public Bitmap c(int i2, int i3, Bitmap.Config config, ImageView.ScaleType scaleType, byte[] bArr) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (i2 == 0 && i3 == 0) {
            options.inPreferredConfig = config;
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        }
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        int b2 = b(i2, i3, i4, i5, scaleType);
        int b3 = b(i3, i2, i5, i4, scaleType);
        options.inJustDecodeBounds = false;
        options.inSampleSize = a(i4, i5, b2, b3);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (decodeByteArray == null) {
            return decodeByteArray;
        }
        if (decodeByteArray.getWidth() <= b2 && decodeByteArray.getHeight() <= b3) {
            return decodeByteArray;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, b2, b3, true);
        decodeByteArray.recycle();
        return createScaledBitmap;
    }
}
