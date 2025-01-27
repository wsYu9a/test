package com.opos.cmn.an.d.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    private static AssetManager f16374a;

    public static AssetManager a(Context context) {
        if (f16374a == null && context != null) {
            f16374a = context.getApplicationContext().getAssets();
        }
        return f16374a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.InputStream a(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "AssetsTool"
            if (r3 == 0) goto L1d
            boolean r1 = com.opos.cmn.an.c.a.a(r4)
            if (r1 != 0) goto L1d
            android.content.res.AssetManager r3 = a(r3)     // Catch: java.lang.Exception -> L13 java.io.IOException -> L17
            java.io.InputStream r3 = r3.open(r4)     // Catch: java.lang.Exception -> L13 java.io.IOException -> L17
            goto L1e
        L13:
            r3 = move-exception
            java.lang.String r1 = "copyFile2Sdcard"
            goto L1a
        L17:
            r3 = move-exception
            java.lang.String r1 = "open"
        L1a:
            com.opos.cmn.an.f.a.c(r0, r1, r3)
        L1d:
            r3 = 0
        L1e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "open fileName="
            r1.append(r2)
            java.lang.String r2 = "null"
            if (r4 == 0) goto L2d
            goto L2e
        L2d:
            r4 = r2
        L2e:
            r1.append(r4)
            java.lang.String r4 = ",inputStream="
            r1.append(r4)
            if (r3 == 0) goto L39
            r2 = r3
        L39:
            r1.append(r2)
            java.lang.String r4 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.a.a.a(android.content.Context, java.lang.String):java.io.InputStream");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap b(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "AssetsTool"
            if (r3 == 0) goto L1b
            boolean r1 = com.opos.cmn.an.c.a.a(r4)
            if (r1 != 0) goto L1b
            java.io.InputStream r3 = a(r3, r4)     // Catch: java.lang.Exception -> L15
            if (r3 == 0) goto L1b
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r3)     // Catch: java.lang.Exception -> L15
            goto L1c
        L15:
            r3 = move-exception
            java.lang.String r1 = "getBitmap"
            com.opos.cmn.an.f.a.c(r0, r1, r3)
        L1b:
            r3 = 0
        L1c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getBitmap fileName="
            r1.append(r2)
            java.lang.String r2 = "null"
            if (r4 == 0) goto L2b
            goto L2c
        L2b:
            r4 = r2
        L2c:
            r1.append(r4)
            java.lang.String r4 = ",bitmap="
            r1.append(r4)
            if (r3 == 0) goto L37
            r2 = r3
        L37:
            r1.append(r2)
            java.lang.String r4 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.a.a.b(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public static Drawable c(Context context, String str) {
        ?? r2 = 0;
        r2 = 0;
        r2 = 0;
        r2 = 0;
        if (context != null && !com.opos.cmn.an.c.a.a(str)) {
            try {
                Bitmap b2 = b(context, str);
                if (b2 != null) {
                    byte[] ninePatchChunk = b2.getNinePatchChunk();
                    StringBuilder sb = new StringBuilder();
                    sb.append("getNinePatchChunk=");
                    sb.append(ninePatchChunk != null ? Integer.valueOf(ninePatchChunk.length) : "null");
                    com.opos.cmn.an.f.a.b("AssetsTool", sb.toString());
                    r2 = (ninePatchChunk == null || ninePatchChunk.length <= 0) ? new BitmapDrawable(b2) : new NinePatchDrawable(b2, ninePatchChunk, new Rect(), null);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("AssetsTool", "getDrawable", e2);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getDrawable fileName=");
        if (str == null) {
            str = "null";
        }
        sb2.append(str);
        sb2.append(",drawable=");
        sb2.append((Object) (r2 != 0 ? r2 : "null"));
        com.opos.cmn.an.f.a.b("AssetsTool", sb2.toString());
        return r2;
    }
}
