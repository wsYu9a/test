package com.kwad.sdk.h;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
final class c {
    public static void a(JSONObject jSONObject, String str, Object obj) {
        if (obj == null || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (Throwable unused) {
            j.Lb();
        }
    }

    public static void putValue(JSONObject jSONObject, String str, List<k> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<k> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().toJson());
                    }
                    jSONObject.put(str, jSONArray);
                }
            } catch (Throwable unused) {
                j.Lb();
            }
        }
    }

    public static void putValue(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (Throwable unused) {
            j.Lb();
        }
    }

    public static void putValue(JSONObject jSONObject, String str, long j10) {
        try {
            jSONObject.put(str, j10);
        } catch (Throwable unused) {
            j.Lb();
        }
    }
}
