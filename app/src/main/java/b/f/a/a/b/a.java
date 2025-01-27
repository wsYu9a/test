package b.f.a.a.b;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.b;

/* loaded from: classes4.dex */
public class a {
    public Bitmap a(b matrix) {
        int l = matrix.l();
        int h2 = matrix.h();
        int[] iArr = new int[l * h2];
        for (int i2 = 0; i2 < l; i2++) {
            for (int i3 = 0; i3 < h2; i3++) {
                int i4 = -1;
                if (matrix.e(i2, i3)) {
                    i4 = -16777216;
                }
                iArr[(i3 * l) + i2] = i4;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(l, h2, Bitmap.Config.RGB_565);
        createBitmap.setPixels(iArr, 0, l, 0, 0, l, h2);
        return createBitmap;
    }

    public Bitmap b(String content) {
        try {
            return a(new com.google.zxing.u.b().b(content, BarcodeFormat.QR_CODE, 500, 500));
        } catch (WriterException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
