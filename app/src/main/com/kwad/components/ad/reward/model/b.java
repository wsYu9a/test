package com.kwad.components.ad.reward.model;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.ad;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

@KsJson
/* loaded from: classes2.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat hX = new SimpleDateFormat("yyyy-MM-dd");
    public long kN = -1;
    public int kO = 0;

    public static void K(Context context) {
        String Nx = ad.Nx();
        b bVar = new b();
        if (TextUtils.isEmpty(Nx)) {
            bVar.kO = 1;
            bVar.kN = System.currentTimeMillis();
            ad.ae(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(Nx));
            if (c(bVar.kN, System.currentTimeMillis())) {
                bVar.kO++;
            } else {
                bVar.kO = 1;
                bVar.kN = System.currentTimeMillis();
            }
            ad.ae(context, bVar.toJson().toString());
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
    }

    private static boolean c(long j10, long j11) {
        if (j10 > 0 && j11 > 0) {
            try {
                return hX.format(new Date(j10)).equals(hX.format(new Date(j11)));
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.printStackTrace(e10);
            }
        }
        return false;
    }

    public static int dk() {
        String Nx = ad.Nx();
        if (TextUtils.isEmpty(Nx)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Nx));
            if (c(bVar.kN, System.currentTimeMillis())) {
                return bVar.kO;
            }
            return 0;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            return 0;
        }
    }
}
