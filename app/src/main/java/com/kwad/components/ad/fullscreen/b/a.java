package com.kwad.components.ad.fullscreen.b;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {
    public static void G(Context context) {
        b H = H(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (H == null) {
            H = new b(currentTimeMillis, 1);
        } else if (H.f(currentTimeMillis)) {
            H.hZ++;
        } else {
            H.hY = currentTimeMillis;
            H.hZ = 1;
        }
        a(context, H);
    }

    @Nullable
    private static b H(Context context) {
        if (context == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).getString("key_local_info", null));
            b bVar = new b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (Exception e10) {
            c.printStackTraceOnly(e10);
            return null;
        }
    }

    private static void a(Context context, b bVar) {
        if (context == null || bVar == null) {
            c.d("FullScreenLocalHelper", "saveFullScreenLocalInfo illegal arguments.");
        } else {
            context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).edit().putString("key_local_info", bVar.toJson().toString()).apply();
        }
    }

    public static boolean b(Context context, AdTemplate adTemplate) {
        b H = H(context);
        return (H == null || !H.w(com.kwad.components.ad.fullscreen.a.b.ck())) && com.kwad.sdk.core.response.b.b.dq(adTemplate);
    }
}
