package com.kwad.components.ad.interstitial.b;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

@KsJson
/* loaded from: classes.dex */
public class a extends com.kwad.sdk.core.response.kwai.a {
    private static SimpleDateFormat gp = new SimpleDateFormat("yyyy-MM-dd");
    public long jl = -1;
    public int jm = 0;

    public static void L(Context context) {
        String Du = y.Du();
        a aVar = new a();
        if (TextUtils.isEmpty(Du)) {
            aVar.jm = 1;
            aVar.jl = System.currentTimeMillis();
            y.X(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(Du));
            if (b(aVar.jl, System.currentTimeMillis())) {
                aVar.jm++;
            } else {
                aVar.jm = 1;
                aVar.jl = System.currentTimeMillis();
            }
            y.X(context, aVar.toJson().toString());
        } catch (Exception e2) {
            b.printStackTrace(e2);
        }
    }

    private static boolean b(long j2, long j3) {
        if (j2 > 0 && j3 > 0) {
            try {
                return gp.format(new Date(j2)).equals(gp.format(new Date(j3)));
            } catch (Exception e2) {
                b.printStackTrace(e2);
            }
        }
        return false;
    }

    public static int cQ() {
        String Du = y.Du();
        if (TextUtils.isEmpty(Du)) {
            return 0;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(Du));
            if (b(aVar.jl, System.currentTimeMillis())) {
                return aVar.jm;
            }
            return 0;
        } catch (Exception e2) {
            b.printStackTrace(e2);
            return 0;
        }
    }
}
