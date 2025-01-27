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
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat hX = new SimpleDateFormat("yyyy-MM-dd");
    public long hY = -1;
    public int kL = 0;
    public int kM = 0;

    public static void I(Context context) {
        String Nt = ad.Nt();
        b bVar = new b();
        if (TextUtils.isEmpty(Nt)) {
            bVar.kL = 1;
            bVar.hY = System.currentTimeMillis();
            ad.Z(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(Nt));
            if (c(bVar.hY, System.currentTimeMillis())) {
                bVar.kL++;
            } else {
                bVar.kL = 1;
                bVar.kM = 0;
                bVar.hY = System.currentTimeMillis();
            }
            ad.Z(context, bVar.toJson().toString());
        } catch (Exception e10) {
            c.printStackTraceOnly(e10);
        }
    }

    public static void J(Context context) {
        String Nt = ad.Nt();
        b bVar = new b();
        if (TextUtils.isEmpty(Nt)) {
            bVar.kM = 1;
            bVar.hY = System.currentTimeMillis();
            ad.Z(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(Nt));
            if (c(bVar.hY, System.currentTimeMillis())) {
                bVar.kM++;
            } else {
                bVar.kM = 1;
                bVar.kL = 0;
                bVar.hY = System.currentTimeMillis();
            }
            ad.Z(context, bVar.toJson().toString());
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
        String Nt = ad.Nt();
        if (TextUtils.isEmpty(Nt)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Nt));
            return bVar.kL;
        } catch (Exception e10) {
            c.printStackTraceOnly(e10);
            return 0;
        }
    }

    public static int dj() {
        String Nt = ad.Nt();
        if (TextUtils.isEmpty(Nt)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Nt));
            return bVar.kM;
        } catch (Exception e10) {
            c.printStackTraceOnly(e10);
            return 0;
        }
    }
}
