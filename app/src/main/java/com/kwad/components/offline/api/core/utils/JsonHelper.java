package com.kwad.components.offline.api.core.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.model.IOfflineCompoJsonParse;
import com.kwad.sdk.core.d.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class JsonHelper {
    public static <T> List<T> jsonArrayToList(String str, Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            return jsonArrayToList(new JSONArray(str), cls);
        } catch (JSONException e2) {
            b.printStackTraceOnly(e2);
            return arrayList;
        }
    }

    public static <T> List<T> jsonArrayToList(JSONArray jSONArray, Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    Object obj = jSONArray.get(i2);
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                } catch (Exception e2) {
                    b.printStackTraceOnly(e2);
                }
            }
        }
        return arrayList;
    }

    public static void merge(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            Object opt = jSONObject2.opt(obj);
            if (opt != null) {
                try {
                    jSONObject.put(obj, opt);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static Map<String, String> parseJSON2MapString(String str) {
        try {
            return parseJSON2MapString(new JSONObject(str));
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    public static Map<String, String> parseJSON2MapString(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String str = "";
            String optString = jSONObject.optString(next, "");
            if (!TextUtils.isEmpty(optString) && !TextUtils.equals("null", optString)) {
                str = optString;
            }
            hashMap.put(next, str);
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

    public static void putValue(JSONArray jSONArray, JSONObject jSONObject) {
        jSONArray.put(jSONObject);
    }

    public static void putValue(JSONObject jSONObject, String str, byte b2) {
        try {
            jSONObject.put(str, (int) b2);
        } catch (JSONException unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, double d2) {
        try {
            jSONObject.put(str, d2);
        } catch (JSONException unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, float f2) {
        try {
            jSONObject.put(str, f2);
        } catch (JSONException unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, int i2) {
        try {
            jSONObject.put(str, i2);
        } catch (JSONException unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, long j2) {
        try {
            jSONObject.put(str, j2);
        } catch (JSONException unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, IOfflineCompoJsonParse iOfflineCompoJsonParse) {
        if (iOfflineCompoJsonParse == null) {
            return;
        }
        try {
            jSONObject.put(str, iOfflineCompoJsonParse.toJson());
        } catch (JSONException unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, List<?> list) {
        if (list == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        boolean z = false;
        for (Object obj : list) {
            if (obj instanceof IOfflineCompoJsonParse) {
                putValue(jSONArray, ((IOfflineCompoJsonParse) obj).toJson());
            } else if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof JSONObject) || (obj instanceof JSONArray) || (obj instanceof Double) || (obj instanceof Boolean)) {
                jSONArray.put(obj);
            } else if (!(obj instanceof Float)) {
                break;
            } else {
                try {
                    jSONArray.put(((Float) obj).floatValue());
                } catch (JSONException unused) {
                }
            }
            z = true;
        }
        if (z) {
            putValue(jSONObject, str, jSONArray);
        }
    }

    public static void putValue(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0 || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, jSONArray);
        } catch (JSONException unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject2 == null || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, jSONObject2);
        } catch (JSONException unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, z);
        } catch (JSONException unused) {
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

    public static <T extends IOfflineCompoJsonParse> JSONArray toJsonArrayForJsonParseList(@NonNull List<T> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJson());
        }
        return jSONArray;
    }
}
