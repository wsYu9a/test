package com.opos.cmn.an.d.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* loaded from: classes4.dex */
public final class a {
    private static int a(BitmapFactory.Options options, int i2, int i3) {
        int i4 = 1;
        if (options != null) {
            try {
                int i5 = options.outHeight;
                int i6 = options.outWidth;
                com.opos.cmn.an.f.a.b("BitmapTool", "options.outHeight=" + i5 + ",options.outWidth=" + i6);
                if (i5 > i3 || i6 > i2) {
                    int i7 = i5 / 2;
                    int i8 = i6 / 2;
                    while (i7 / i4 > i3 && i8 / i4 > i2) {
                        i4 *= 2;
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("BitmapTool", "", e2);
            }
        }
        com.opos.cmn.an.f.a.b("BitmapTool", "calculateInSampleSize reqWidth=" + i2 + ",reqHeight=" + i3 + ",inSampleSize=" + i4);
        return i4;
    }

    public static Bitmap a(Bitmap bitmap, int i2, int i3, int i4) {
        Bitmap bitmap2 = null;
        if (bitmap != null) {
            try {
                bitmap2 = Bitmap.createScaledBitmap(bitmap, i2, i3, true);
                if (bitmap != bitmap2) {
                    com.opos.cmn.an.f.a.b("BitmapTool", "src != dst,src.recycle()");
                    bitmap.recycle();
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("BitmapTool", "", e2);
            }
        }
        return bitmap2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap a(java.lang.String r4, int r5, int r6) {
        /*
            java.lang.String r0 = "BitmapTool"
            boolean r1 = com.opos.cmn.an.c.a.a(r4)     // Catch: java.lang.Exception -> L27
            if (r1 != 0) goto L2d
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Exception -> L27
            r1.<init>()     // Catch: java.lang.Exception -> L27
            r2 = 1
            r1.inJustDecodeBounds = r2     // Catch: java.lang.Exception -> L27
            android.graphics.BitmapFactory.decodeFile(r4, r1)     // Catch: java.lang.Exception -> L27
            int r2 = a(r1, r5, r6)     // Catch: java.lang.Exception -> L27
            r1.inSampleSize = r2     // Catch: java.lang.Exception -> L27
            r2 = 0
            r1.inJustDecodeBounds = r2     // Catch: java.lang.Exception -> L27
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeFile(r4, r1)     // Catch: java.lang.Exception -> L27
            int r1 = r1.inSampleSize     // Catch: java.lang.Exception -> L27
            android.graphics.Bitmap r1 = a(r2, r5, r6, r1)     // Catch: java.lang.Exception -> L27
            goto L2e
        L27:
            r1 = move-exception
            java.lang.String r2 = ""
            com.opos.cmn.an.f.a.c(r0, r2, r1)
        L2d:
            r1 = 0
        L2e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "decodeSampledBitmapFromFile pathName="
            r2.append(r3)
            java.lang.String r3 = "null"
            if (r4 == 0) goto L3d
            goto L3e
        L3d:
            r4 = r3
        L3e:
            r2.append(r4)
            java.lang.String r4 = ",reqWidth="
            r2.append(r4)
            r2.append(r5)
            java.lang.String r4 = ",reqHeight="
            r2.append(r4)
            r2.append(r6)
            java.lang.String r4 = ",dst="
            r2.append(r4)
            if (r1 == 0) goto L59
            r3 = r1
        L59:
            r2.append(r3)
            java.lang.String r4 = r2.toString()
            com.opos.cmn.an.f.a.b(r0, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.c.a.a(java.lang.String, int, int):android.graphics.Bitmap");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap b(java.lang.String r4, int r5, int r6) {
        /*
            java.lang.String r0 = "BitmapTool"
            boolean r1 = com.opos.cmn.an.c.a.a(r4)     // Catch: java.lang.Exception -> L21
            if (r1 != 0) goto L27
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Exception -> L21
            r1.<init>()     // Catch: java.lang.Exception -> L21
            r2 = 1
            r1.inJustDecodeBounds = r2     // Catch: java.lang.Exception -> L21
            android.graphics.BitmapFactory.decodeFile(r4, r1)     // Catch: java.lang.Exception -> L21
            int r2 = a(r1, r5, r6)     // Catch: java.lang.Exception -> L21
            r1.inSampleSize = r2     // Catch: java.lang.Exception -> L21
            r2 = 0
            r1.inJustDecodeBounds = r2     // Catch: java.lang.Exception -> L21
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeFile(r4, r1)     // Catch: java.lang.Exception -> L21
            goto L28
        L21:
            r1 = move-exception
            java.lang.String r2 = ""
            com.opos.cmn.an.f.a.c(r0, r2, r1)
        L27:
            r1 = 0
        L28:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "decodeBitmapFromFileWithoutScale pathName="
            r2.append(r3)
            java.lang.String r3 = "null"
            if (r4 == 0) goto L37
            goto L38
        L37:
            r4 = r3
        L38:
            r2.append(r4)
            java.lang.String r4 = ",reqWidth="
            r2.append(r4)
            r2.append(r5)
            java.lang.String r4 = ",reqHeight="
            r2.append(r4)
            r2.append(r6)
            java.lang.String r4 = ",dst="
            r2.append(r4)
            if (r1 == 0) goto L53
            r3 = r1
        L53:
            r2.append(r3)
            java.lang.String r4 = r2.toString()
            com.opos.cmn.an.f.a.b(r0, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.c.a.b(java.lang.String, int, int):android.graphics.Bitmap");
    }
}
