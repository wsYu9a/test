package com.kwad.components.ad.fullscreen.a;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {
    public static void H(Context context) {
        b I = I(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (I == null) {
            I = new b(currentTimeMillis, 1);
        } else if (I.e(currentTimeMillis)) {
            I.gr++;
        } else {
            I.gq = currentTimeMillis;
            I.gr = 1;
        }
        a(context, I);
    }

    @Nullable
    private static b I(Context context) {
        if (context == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).getString("key_local_info", null));
            b bVar = new b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }

    private static void a(Context context, b bVar) {
        if (context == null || bVar == null) {
            com.kwad.sdk.core.d.b.d("FullScreenLocalHelper", "saveFullScreenLocalInfo illegal arguments.");
        } else {
            context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).edit().putString("key_local_info", bVar.toJson().toString()).apply();
        }
    }

    public static boolean a(Context context, AdTemplate adTemplate) {
        b I = I(context);
        return (I == null || !I.z(com.kwad.components.ad.fullscreen.kwai.b.bQ())) && com.kwad.sdk.core.response.a.b.bK(adTemplate);
    }
}
