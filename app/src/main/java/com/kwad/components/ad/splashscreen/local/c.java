package com.kwad.components.ad.splashscreen.local;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

@KsJson
/* loaded from: classes2.dex */
public class c extends com.kwad.sdk.core.response.kwai.a {
    private static SimpleDateFormat gp = new SimpleDateFormat("yyyy-MM-dd");
    public long gq = 0;
    public int gr = 0;

    public static void R(Context context) {
        String Ds = y.Ds();
        c cVar = new c();
        if (TextUtils.isEmpty(Ds)) {
            cVar.gr = 1;
            cVar.gq = System.currentTimeMillis();
            y.V(context, cVar.toJson().toString());
            return;
        }
        try {
            cVar.parseJson(new JSONObject(Ds));
            if (b(cVar.gq, System.currentTimeMillis())) {
                cVar.gr++;
            } else {
                cVar.gr = 1;
            }
            cVar.gq = System.currentTimeMillis();
            y.V(context, cVar.toJson().toString());
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
}
