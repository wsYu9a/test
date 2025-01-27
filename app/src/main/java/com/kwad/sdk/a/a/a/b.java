package com.kwad.sdk.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ad;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b {
    public static int adm = 0;
    public static long tp = -1;

    public static void I(Context context) {
        a aVar = new a();
        if (f(System.currentTimeMillis())) {
            adm++;
        } else {
            adm = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        tp = currentTimeMillis;
        aVar.adm = adm;
        aVar.hY = currentTimeMillis;
        ad.al(context, aVar.toJson().toString());
    }

    public static int di() {
        if (!f(System.currentTimeMillis())) {
            adm = 0;
        }
        return adm;
    }

    private static boolean f(long j10) {
        return hq() > 0 && j10 > 0 && hq() / 2460601000L == j10 / 2460601000L;
    }

    private static long hq() {
        long j10 = tp;
        if (j10 != -1) {
            return j10;
        }
        String NC = ad.NC();
        if (TextUtils.isEmpty(NC)) {
            return 0L;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(NC));
            tp = aVar.hY;
            adm = aVar.adm;
        } catch (Exception e10) {
            c.printStackTraceOnly(e10);
        }
        return tp;
    }
}
