package com.kwad.components.core.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.d.c;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b {
    public static boolean ao(Context context) {
        boolean z10;
        if (context == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_local_ad_force_active", 0);
        a aVar = new a();
        if (sharedPreferences.contains("ksadsdk_local_ad_force_active_data")) {
            String string = sharedPreferences.getString("ksadsdk_local_ad_force_active_data", null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    aVar.parseJson(new JSONObject(string));
                } catch (Exception e10) {
                    c.printStackTraceOnly(e10);
                }
            }
            z10 = aVar.j(d.DH(), d.DI());
            c.d("LocalAdForceActiveHelper", "addCount contains success: " + z10);
        } else {
            c.d("LocalAdForceActiveHelper", "addCount not contains");
            aVar.px();
            z10 = true;
        }
        if (z10) {
            sharedPreferences.edit().putString("ksadsdk_local_ad_force_active_data", aVar.toJson().toString()).apply();
        }
        return z10;
    }
}
