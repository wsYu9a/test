package com.kwad.components.ad.interstitial.d;

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
    public long kN = -1;
    public int kO = 0;

    public static void K(Context context) {
        String Ny = ad.Ny();
        a aVar = new a();
        if (TextUtils.isEmpty(Ny)) {
            aVar.kO = 1;
            aVar.kN = System.currentTimeMillis();
            ad.af(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(Ny));
            if (c(aVar.kN, System.currentTimeMillis())) {
                aVar.kO++;
            } else {
                aVar.kO = 1;
                aVar.kN = System.currentTimeMillis();
            }
            ad.af(context, aVar.toJson().toString());
        } catch (Exception e10) {
            c.printStackTrace(e10);
        }
    }

    private static boolean c(long j10, long j11) {
        if (j10 > 0 && j11 > 0) {
            try {
                return hX.format(new Date(j10)).equals(hX.format(new Date(j11)));
            } catch (Exception e10) {
                c.printStackTrace(e10);
            }
        }
        return false;
    }

    public static int dk() {
        String Ny = ad.Ny();
        if (TextUtils.isEmpty(Ny)) {
            return 0;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(Ny));
            if (c(aVar.kN, System.currentTimeMillis())) {
                return aVar.kO;
            }
            return 0;
        } catch (Exception e10) {
            c.printStackTrace(e10);
            return 0;
        }
    }
}
