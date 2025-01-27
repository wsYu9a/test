package com.kwad.components.ad.reward.h;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ad;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {
    public static long tp = -1;
    public static int tq;

    public static void I(Context context) {
        b bVar = new b();
        if (f(System.currentTimeMillis())) {
            tq++;
        } else {
            tq = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        tp = currentTimeMillis;
        bVar.tr = tq;
        bVar.hY = currentTimeMillis;
        ad.ac(context, bVar.toJson().toString());
    }

    public static int di() {
        if (!f(System.currentTimeMillis())) {
            tq = 0;
        }
        return tq;
    }

    private static boolean f(long j10) {
        return hq() > 0 && j10 > 0 && hq() / 2460601000L == j10 / 2460601000L;
    }

    private static long hq() {
        long j10 = tp;
        if (j10 != -1) {
            return j10;
        }
        String Nv = ad.Nv();
        if (TextUtils.isEmpty(Nv)) {
            return 0L;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Nv));
            tp = bVar.hY;
            tq = bVar.tr;
        } catch (Exception e10) {
            c.printStackTraceOnly(e10);
        }
        return tp;
    }
}
