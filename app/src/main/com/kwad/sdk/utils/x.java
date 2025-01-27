package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class x {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static <T> JSONArray N(List<T> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    for (T t10 : list) {
                        if (t10 != null) {
                            if (t10 instanceof JSONObject) {
                                jSONArray.put(t10);
                            } else if (t10 instanceof com.kwad.sdk.core.b) {
                                jSONArray.put(((com.kwad.sdk.core.b) t10).toJson());
                            } else {
                                if (!(t10 instanceof String)) {
                                    throw new IllegalArgumentException("<T> now suppprt type: " + t10.getClass().getName());
                                }
                                jSONArray.put(t10);
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
        return jSONArray;
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

    @NonNull
    public static <T extends com.kwad.sdk.core.b> T b(@Nullable String str, @NonNull com.kwad.sdk.core.c<T> cVar) {
        T Ct = cVar.Ct();
        try {
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
        if (TextUtils.isEmpty(str)) {
            return Ct;
        }
        try {
            Ct.parseJson(new JSONObject(str));
        } catch (Throwable th3) {
            com.kwad.sdk.core.d.c.printStackTrace(th3);
        }
        return Ct;
    }

    public static <T> List<T> gK(String str) {
        return y.gK(str);
    }

    public static <T> List<T> h(JSONArray jSONArray) {
        return y.h(jSONArray);
    }

    public static Map<String, String> parseJSON2MapString(String str) {
        return y.parseJSON2MapString(str);
    }

    public static JSONObject parseMap2JSON(Map<String, String> map) {
        return y.parseMap2JSON(map);
    }

    public static void putValue(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return;
        }
        y.putValue(jSONObject, str, str2);
    }

    public static JSONArray toJsonArray(@NonNull List<String> list) {
        return y.toJsonArray(list);
    }

    public static JSONArray a(JSONArray jSONArray, JSONObject jSONObject) {
        try {
            jSONArray.put(jSONObject);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
        return jSONArray;
    }

    public static void putValue(JSONObject jSONObject, String str, double d10) {
        if (jSONObject == null) {
            return;
        }
        y.putValue(jSONObject, str, d10);
    }

    public static void putValue(JSONObject jSONObject, String str, int i10) {
        if (jSONObject == null) {
            return;
        }
        y.putValue(jSONObject, str, i10);
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2, boolean z10) {
        try {
            y.a(jSONObject, jSONObject2, z10);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void putValue(JSONObject jSONObject, String str, float f10) {
        if (jSONObject == null) {
            return;
        }
        y.putValue(jSONObject, str, f10);
    }

    public static void putValue(JSONObject jSONObject, String str, byte b10) {
        if (jSONObject == null) {
            return;
        }
        y.putValue(jSONObject, str, b10);
    }

    public static <T extends com.kwad.sdk.core.b> List<T> a(String str, @NonNull com.kwad.sdk.core.c<T> cVar) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                T Ct = cVar.Ct();
                Ct.parseJson(jSONObject);
                arrayList.add(Ct);
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
        return arrayList;
    }

    public static void putValue(JSONObject jSONObject, String str, long j10) {
        if (jSONObject == null) {
            return;
        }
        y.putValue(jSONObject, str, j10);
    }

    public static void putValue(JSONObject jSONObject, String str, boolean z10) {
        if (jSONObject == null) {
            return;
        }
        y.putValue(jSONObject, str, z10);
    }

    public static void putValue(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        y.putValue(jSONObject, str, jSONObject2);
    }

    public static void putValue(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONObject == null) {
            return;
        }
        y.putValue(jSONObject, str, jSONArray);
    }

    public static void putValue(JSONObject jSONObject, String str, List<?> list) {
        if (jSONObject == null || list == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            boolean z10 = false;
            for (Object obj : list) {
                if (obj instanceof com.kwad.sdk.core.b) {
                    a(jSONArray, ((com.kwad.sdk.core.b) obj).toJson());
                } else {
                    if (!(obj instanceof String) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof JSONObject) && !(obj instanceof JSONArray) && !(obj instanceof Double) && !(obj instanceof Boolean)) {
                        if (!(obj instanceof Float)) {
                            break;
                        } else {
                            try {
                                jSONArray.put(((Float) obj).floatValue());
                            } catch (JSONException unused) {
                            }
                        }
                    }
                    jSONArray.put(obj);
                }
                z10 = true;
            }
            if (z10) {
                putValue(jSONObject, str, jSONArray);
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }
}
