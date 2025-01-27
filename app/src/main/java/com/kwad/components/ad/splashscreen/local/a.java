package com.kwad.components.ad.splashscreen.local;

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
    public long hY = 0;
    public int hZ = 0;

    public static void T(Context context) {
        String Nw = ad.Nw();
        a aVar = new a();
        if (TextUtils.isEmpty(Nw)) {
            aVar.hZ = 1;
            aVar.hY = System.currentTimeMillis();
            ad.ad(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(Nw));
            if (c(aVar.hY, System.currentTimeMillis())) {
                aVar.hZ++;
            } else {
                aVar.hZ = 1;
            }
            aVar.hY = System.currentTimeMillis();
            ad.ad(context, aVar.toJson().toString());
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
}
