package com.kwad.components.ad.reward.e;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.y;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {
    public static int rA = 0;
    public static long rz = -1;

    public static void J(Context context) {
        b bVar = new b();
        if (e(System.currentTimeMillis())) {
            rA++;
        } else {
            rA = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        rz = currentTimeMillis;
        bVar.rB = rA;
        bVar.gq = currentTimeMillis;
        y.U(context, bVar.toJson().toString());
    }

    public static int cO() {
        if (!e(System.currentTimeMillis())) {
            rA = 0;
        }
        return rA;
    }

    private static boolean e(long j2) {
        return gX() > 0 && j2 > 0 && gX() / 2460601000L == j2 / 2460601000L;
    }

    private static long gX() {
        long j2 = rz;
        if (j2 != -1) {
            return j2;
        }
        String Dr = y.Dr();
        if (TextUtils.isEmpty(Dr)) {
            return 0L;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Dr));
            rz = bVar.gq;
            rA = bVar.rB;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        return rz;
    }
}
