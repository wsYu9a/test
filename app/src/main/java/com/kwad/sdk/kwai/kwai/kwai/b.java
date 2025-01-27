package com.kwad.sdk.kwai.kwai.kwai;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.y;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b {
    public static int UX = 0;
    public static long rz = -1;

    public static void J(Context context) {
        a aVar = new a();
        if (e(System.currentTimeMillis())) {
            UX++;
        } else {
            UX = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        rz = currentTimeMillis;
        aVar.UX = UX;
        aVar.gq = currentTimeMillis;
        y.ae(context, aVar.toJson().toString());
    }

    public static int cO() {
        if (!e(System.currentTimeMillis())) {
            UX = 0;
        }
        return UX;
    }

    private static boolean e(long j2) {
        return gX() > 0 && j2 > 0 && gX() / 2460601000L == j2 / 2460601000L;
    }

    private static long gX() {
        long j2 = rz;
        if (j2 != -1) {
            return j2;
        }
        String Dz = y.Dz();
        if (TextUtils.isEmpty(Dz)) {
            return 0L;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(Dz));
            rz = aVar.gq;
            UX = aVar.UX;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        return rz;
    }
}
