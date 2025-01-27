package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ai {
    public static JSONObject a(Context context) {
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            int parseInt = Integer.parseInt(property2);
            if (TextUtils.isEmpty(property) || parseInt == -1) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("h", property);
            jSONObject.put("p", parseInt);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
