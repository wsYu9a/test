package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class t {
    public static <T> JSONArray C(List<T> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            for (Object obj : list) {
                if (obj != null) {
                    if (!(obj instanceof JSONObject)) {
                        if (obj instanceof com.kwad.sdk.core.b) {
                            obj = ((com.kwad.sdk.core.b) obj).toJson();
                        } else if (!(obj instanceof String)) {
                            throw new IllegalArgumentException("<T> now suppprt type: " + obj.getClass().getName());
                        }
                    }
                    jSONArray.put(obj);
                }
            }
        }
        return jSONArray;
    }

    public static <T extends com.kwad.sdk.core.b> List<T> a(String str, @NonNull com.kwad.sdk.core.c<T> cVar) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                T tU = cVar.tU();
                tU.parseJson(jSONObject);
                arrayList.add(tU);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        return arrayList;
    }

    public static void a(JSONObject jSONObject, String str, com.kwad.sdk.core.b bVar) {
        if (jSONObject == null || bVar == null) {
            return;
        }
        try {
            jSONObject.put(str, bVar.toJson());
        } catch (JSONException unused) {
        }
    }

    public static <T> List<T> eB(String str) {
        return u.eB(str);
    }

    public static <T> List<T> h(JSONArray jSONArray) {
        return u.h(jSONArray);
    }

    public static void merge(JSONObject jSONObject, JSONObject jSONObject2) {
        u.merge(jSONObject, jSONObject2);
    }

    public static Map<String, String> parseJSON2MapString(String str) {
        return u.parseJSON2MapString(str);
    }

    public static JSONObject parseMap2JSON(Map<String, String> map) {
        return u.parseMap2JSON(map);
    }

    public static void putValue(JSONArray jSONArray, JSONObject jSONObject) {
        jSONArray.put(jSONObject);
    }

    public static void putValue(JSONObject jSONObject, String str, byte b2) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, b2);
    }

    public static void putValue(JSONObject jSONObject, String str, double d2) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, d2);
    }

    public static void putValue(JSONObject jSONObject, String str, float f2) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, f2);
    }

    public static void putValue(JSONObject jSONObject, String str, int i2) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, i2);
    }

    public static void putValue(JSONObject jSONObject, String str, long j2) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, j2);
    }

    public static void putValue(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, str2);
    }

    public static void putValue(JSONObject jSONObject, String str, List<?> list) {
        if (jSONObject == null || list == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        boolean z = false;
        for (Object obj : list) {
            if (obj instanceof com.kwad.sdk.core.b) {
                putValue(jSONArray, ((com.kwad.sdk.core.b) obj).toJson());
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
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, jSONArray);
    }

    public static void putValue(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, jSONObject2);
    }

    public static void putValue(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, z);
    }

    public static JSONArray toJsonArray(@NonNull List<String> list) {
        return u.toJsonArray(list);
    }
}
