package com.kwad.components.ad.interstitial.a;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

@KsJson
/* loaded from: classes.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    private static SimpleDateFormat gp = new SimpleDateFormat("yyyy-MM-dd");
    public long gq = -1;
    public int jj = 0;
    public int jk = 0;

    public static void J(Context context) {
        String Dp = y.Dp();
        b bVar = new b();
        if (TextUtils.isEmpty(Dp)) {
            bVar.jj = 1;
            bVar.gq = System.currentTimeMillis();
            y.R(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(Dp));
            if (b(bVar.gq, System.currentTimeMillis())) {
                bVar.jj++;
            } else {
                bVar.jj = 1;
                bVar.jk = 0;
                bVar.gq = System.currentTimeMillis();
            }
            y.R(context, bVar.toJson().toString());
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    public static void K(Context context) {
        String Dp = y.Dp();
        b bVar = new b();
        if (TextUtils.isEmpty(Dp)) {
            bVar.jk = 1;
            bVar.gq = System.currentTimeMillis();
            y.R(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(Dp));
            if (b(bVar.gq, System.currentTimeMillis())) {
                bVar.jk++;
            } else {
                bVar.jk = 1;
                bVar.jj = 0;
                bVar.gq = System.currentTimeMillis();
            }
            y.R(context, bVar.toJson().toString());
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    private static boolean b(long j2, long j3) {
        if (j2 > 0 && j3 > 0) {
            try {
                return gp.format(new Date(j2)).equals(gp.format(new Date(j3)));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }
        return false;
    }

    public static int cO() {
        String Dp = y.Dp();
        if (TextUtils.isEmpty(Dp)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Dp));
            return bVar.jj;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return 0;
        }
    }

    public static int cP() {
        String Dp = y.Dp();
        if (TextUtils.isEmpty(Dp)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Dp));
            return bVar.jk;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return 0;
        }
    }
}
