package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class y {
    public static void a(JSONObject jSONObject, JSONObject jSONObject2, boolean z10) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            Object opt = jSONObject2.opt(obj);
            if (opt != null) {
                try {
                    if (!jSONObject.has(obj)) {
                        jSONObject.put(obj, opt);
                    } else if (z10) {
                        jSONObject.put(obj, opt);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static <T> List<T> gK(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            return h(new JSONArray(str));
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
            return arrayList;
        }
    }

    public static <T> List<T> h(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                Object obj = jSONArray.get(i10);
                if (obj != null) {
                    arrayList.add(obj);
                }
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTrace(th2);
            }
        }
        return arrayList;
    }

    public static void merge(JSONObject jSONObject, JSONObject jSONObject2) {
        a(jSONObject, jSONObject2, true);
    }

    public static Map<String, String> parseJSON2MapString(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next, "");
                if (TextUtils.isEmpty(optString) || TextUtils.equals("null", optString)) {
                    optString = "";
                }
                hashMap.put(next, optString);
            }
        } catch (JSONException unused) {
        }
        return hashMap;
    }

    public static JSONObject parseMap2JSON(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null && !map.isEmpty()) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static void putValue(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (Throwable unused) {
        }
    }

    public static JSONArray toJsonArray(@NonNull List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        return jSONArray;
    }

    public static void putValue(JSONObject jSONObject, String str, double d10) {
        try {
            jSONObject.put(str, d10);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, int i10) {
        try {
            jSONObject.put(str, i10);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, float f10) {
        try {
            jSONObject.put(str, f10);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, byte b10) {
        try {
            jSONObject.put(str, (int) b10);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, long j10) {
        try {
            jSONObject.put(str, j10);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, boolean z10) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, z10);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject2 == null || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, jSONObject2);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0 || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, jSONArray);
        } catch (Throwable unused) {
        }
    }
}
