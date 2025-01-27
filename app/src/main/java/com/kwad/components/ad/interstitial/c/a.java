package com.kwad.components.ad.interstitial.c;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ad;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

@KsJson
/* loaded from: classes2.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat hX = new SimpleDateFormat("yyyy-MM-dd");
    public long hY = -1;
    public int kK = 0;

    public static void I(Context context) {
        String Nu = ad.Nu();
        a aVar = new a();
        if (TextUtils.isEmpty(Nu)) {
            aVar.kK = 1;
            aVar.hY = System.currentTimeMillis();
            ad.aa(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(Nu));
            if (c(aVar.hY, System.currentTimeMillis())) {
                aVar.kK++;
            } else {
                aVar.kK = 1;
                aVar.hY = System.currentTimeMillis();
            }
            ad.aa(context, aVar.toJson().toString());
        } catch (Exception e10) {
            c.printStackTraceOnly(e10);
        }
    }

    private static boolean c(long j10, long j11) {
        if (j10 > 0 && j11 > 0) {
            try {
                return hX.format(new Date(j10)).equals(hX.format(new Date(j11)));
            } catch (Exception e10) {
                c.printStackTraceOnly(e10);
            }
        }
        return false;
    }

    public static int di() {
        String Nu = ad.Nu();
        if (TextUtils.isEmpty(Nu)) {
            return 0;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(Nu));
            if (c(aVar.hY, System.currentTimeMillis())) {
                return aVar.kK;
            }
            return 0;
        } catch (Exception e10) {
            c.printStackTraceOnly(e10);
            return 0;
        }
    }
}
