package com.alipay.sdk.util;

import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d {
    private static String a(String str, String str2) {
        String a2 = b.b.a.d.d.a(str, b.b.a.b.a.f4190c);
        String a3 = b.b.a.d.e.a(str, str2);
        return String.format(Locale.getDefault(), "%08X%s%08X%s", Integer.valueOf(a2.length()), a2, Integer.valueOf(a3.length()), a3);
    }

    public static JSONObject b(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            JSONObject[] jSONObjectArr = {jSONObject, jSONObject2};
            for (int i2 = 0; i2 < 2; i2++) {
                JSONObject jSONObject4 = jSONObjectArr[i2];
                if (jSONObject4 != null) {
                    Iterator<String> keys = jSONObject4.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject3.put(next, jSONObject4.get(next));
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return jSONObject3;
    }
}
