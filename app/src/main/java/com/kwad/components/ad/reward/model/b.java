package com.kwad.components.ad.reward.model;

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
    public long jl = -1;
    public int jm = 0;

    public static void L(Context context) {
        String Dt = y.Dt();
        b bVar = new b();
        if (TextUtils.isEmpty(Dt)) {
            bVar.jm = 1;
            bVar.jl = System.currentTimeMillis();
            y.W(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(Dt));
            if (b(bVar.jl, System.currentTimeMillis())) {
                bVar.jm++;
            } else {
                bVar.jm = 1;
                bVar.jl = System.currentTimeMillis();
            }
            y.W(context, bVar.toJson().toString());
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    private static boolean b(long j2, long j3) {
        if (j2 > 0 && j3 > 0) {
            try {
                return gp.format(new Date(j2)).equals(gp.format(new Date(j3)));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        return false;
    }

    public static int cQ() {
        String Dt = y.Dt();
        if (TextUtils.isEmpty(Dt)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Dt));
            if (b(bVar.jl, System.currentTimeMillis())) {
                return bVar.jm;
            }
            return 0;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return 0;
        }
    }
}
