package re;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import z5.b;

/* loaded from: classes3.dex */
public class a {
    public Bitmap a(b bVar) {
        int l10 = bVar.l();
        int h10 = bVar.h();
        int[] iArr = new int[l10 * h10];
        for (int i10 = 0; i10 < l10; i10++) {
            for (int i11 = 0; i11 < h10; i11++) {
                iArr[(i11 * l10) + i10] = bVar.e(i10, i11) ? -16777216 : -1;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(l10, h10, Bitmap.Config.RGB_565);
        createBitmap.setPixels(iArr, 0, l10, 0, 0, l10, h10);
        return createBitmap;
    }

    public Bitmap b(String str) {
        try {
            return a(new s6.b().b(str, BarcodeFormat.QR_CODE, 500, 500));
        } catch (WriterException e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
