package com.vivo.mobilead.util;

import android.R;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: a */
    private static AssetManager f30631a;

    private static AssetManager a(Context context) {
        if (f30631a == null && context != null) {
            f30631a = context.getApplicationContext().getAssets();
        }
        return f30631a;
    }

    public static Drawable b(Context context, String str) {
        Bitmap a2 = a(context, str);
        if (a2 == null) {
            return null;
        }
        byte[] ninePatchChunk = a2.getNinePatchChunk();
        if (ninePatchChunk != null && ninePatchChunk.length > 0) {
            x0.a("AssetsTool", "NinePatchDrawable " + ninePatchChunk.length + " " + str);
            return new NinePatchDrawable(a2, ninePatchChunk, new Rect(), null);
        }
        x0.a("AssetsTool", "BitmapDrawable " + a2.getWidth() + " " + a2.getHeight() + " " + str);
        return new BitmapDrawable(a2);
    }

    private static InputStream c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return a(context).open(str);
            } catch (Exception e2) {
                x0.b("AssetsTool", "getInputStream", e2);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap a(android.content.Context r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "getBitmap failed: "
            java.lang.String r1 = "AssetsTool"
            r2 = 0
            if (r5 == 0) goto L92
            boolean r3 = android.text.TextUtils.isEmpty(r6)
            if (r3 != 0) goto L92
            java.lang.String r3 = "@assets/"
            boolean r3 = r6.startsWith(r3)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            if (r3 == 0) goto L1b
            r3 = 8
            java.lang.String r6 = r6.substring(r3)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
        L1b:
            java.io.InputStream r5 = c(r5, r6)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r5)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L46
            if (r5 == 0) goto L92
            r5.close()     // Catch: java.lang.Exception -> L2a
            goto L92
        L2a:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            java.lang.String r5 = r5.getMessage()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.vivo.mobilead.util.x0.b(r1, r5)
            goto L92
        L42:
            r6 = move-exception
            r2 = r5
            r5 = r6
            goto L74
        L46:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
            goto L4f
        L4b:
            r5 = move-exception
            goto L74
        L4d:
            r5 = move-exception
            r6 = r2
        L4f:
            java.lang.String r3 = "getBitmap"
            com.vivo.mobilead.util.x0.b(r1, r3, r5)     // Catch: java.lang.Throwable -> L72
            if (r6 == 0) goto L92
            r6.close()     // Catch: java.lang.Exception -> L5a
            goto L92
        L5a:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            java.lang.String r5 = r5.getMessage()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.vivo.mobilead.util.x0.b(r1, r5)
            goto L92
        L72:
            r5 = move-exception
            r2 = r6
        L74:
            if (r2 == 0) goto L91
            r2.close()     // Catch: java.lang.Exception -> L7a
            goto L91
        L7a:
            r6 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r6 = r6.getMessage()
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            com.vivo.mobilead.util.x0.b(r1, r6)
        L91:
            throw r5
        L92:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.util.g.a(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    public static StateListDrawable a(Context context, Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_selected}, drawable2);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawable2);
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, drawable);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }
}
