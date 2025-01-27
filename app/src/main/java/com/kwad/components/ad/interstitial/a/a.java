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
public class a extends com.kwad.sdk.core.response.kwai.a {
    private static SimpleDateFormat gp = new SimpleDateFormat("yyyy-MM-dd");
    public long gq = -1;
    public int ji = 0;

    public static void J(Context context) {
        String Dq = y.Dq();
        a aVar = new a();
        if (TextUtils.isEmpty(Dq)) {
            aVar.ji = 1;
            aVar.gq = System.currentTimeMillis();
            y.S(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(Dq));
            if (b(aVar.gq, System.currentTimeMillis())) {
                aVar.ji++;
            } else {
                aVar.ji = 1;
                aVar.gq = System.currentTimeMillis();
            }
            y.S(context, aVar.toJson().toString());
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
        String Dq = y.Dq();
        if (TextUtils.isEmpty(Dq)) {
            return 0;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(Dq));
            if (b(aVar.gq, System.currentTimeMillis())) {
                return aVar.ji;
            }
            return 0;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return 0;
        }
    }
}
