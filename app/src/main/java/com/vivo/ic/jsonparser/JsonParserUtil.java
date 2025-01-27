package com.vivo.ic.jsonparser;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class JsonParserUtil {
    private static float convertFloat(String str, float f2) {
        if (TextUtils.isEmpty(str)) {
            return f2;
        }
        try {
            return Float.parseFloat(str);
        } catch (Exception unused) {
            return f2;
        }
    }

    private static int convertInt(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i2;
        }
    }

    private static long convertLong(String str, long j2) {
        if (TextUtils.isEmpty(str)) {
            return j2;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j2;
        }
    }

    public static Boolean getBoolean(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.isNull(str)) {
            return Boolean.FALSE;
        }
        try {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        } catch (JSONException unused) {
            return Boolean.FALSE;
        }
    }

    public static float getFloat(String str, JSONObject jSONObject) {
        return getFloat(str, jSONObject, Float.MIN_VALUE);
    }

    public static int getInt(String str, JSONObject jSONObject) {
        return getInt(str, jSONObject, Integer.MIN_VALUE);
    }

    public static JSONArray getJSONArray(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null && !jSONObject.isNull(str)) {
            try {
                return jSONObject.getJSONArray(str);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static long getLong(String str, JSONObject jSONObject) {
        return getLong(str, jSONObject, Long.MIN_VALUE);
    }

    public static JSONObject getObject(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null && !jSONObject.isNull(str)) {
            try {
                return jSONObject.getJSONObject(str);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static String getString(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null && !jSONObject.isNull(str)) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static List<String> getStringArray(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.isNull(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(jSONArray.getString(i2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public static float getFloat(String str, JSONObject jSONObject, float f2) {
        return convertFloat(getString(str, jSONObject), f2);
    }

    public static int getInt(String str, JSONObject jSONObject, int i2) {
        return convertInt(getString(str, jSONObject), i2);
    }

    public static long getLong(String str, JSONObject jSONObject, long j2) {
        return convertLong(getString(str, jSONObject), j2);
    }
}
