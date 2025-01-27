package com.vivo.ic.webview;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class JsonParserUtil {
    private static final String NULL_STRING = "null";

    public static List<String> getArrayStr(String str, JSONObject jSONObject) {
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

    public static Boolean getBoolean(String str, JSONObject jSONObject) {
        try {
            return Boolean.valueOf(jSONObject.isNull(str) ? false : jSONObject.getBoolean(str));
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    public static float getFloat(String str, JSONObject jSONObject) {
        return getFloat(getString(str, jSONObject));
    }

    public static int getInt(String str, JSONObject jSONObject) {
        return getInt(getString(str, jSONObject));
    }

    public static int getIntDefaultMinus(String str, JSONObject jSONObject) {
        String string = getString(str, jSONObject);
        if (!TextUtils.isEmpty(string) && !NULL_STRING.equals(string)) {
            try {
                return Integer.parseInt(string);
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    public static JSONArray getJSONArray(String str, JSONObject jSONObject) {
        if (str == null || jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.isNull(str)) {
                return null;
            }
            return jSONObject.getJSONArray(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject getJson(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                Object value = entry.getValue();
                if (value instanceof Map) {
                    try {
                        jSONObject.put(key, getJson((Map) value));
                    } catch (Exception unused) {
                    }
                } else if (value instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = ((List) value).iterator();
                    while (it.hasNext()) {
                        jSONArray.put(getJson((Map) it.next()));
                        try {
                            jSONObject.put(key, jSONArray);
                        } catch (Exception unused2) {
                        }
                    }
                } else {
                    jSONObject.put(key, value == null ? "" : value.toString());
                }
            }
        }
        return jSONObject;
    }

    public static long getLong(String str, JSONObject jSONObject) {
        return getLong(getString(str, jSONObject));
    }

    public static JSONObject getObject(String str, JSONObject jSONObject) {
        try {
            if (jSONObject.isNull(str)) {
                return null;
            }
            return jSONObject.getJSONObject(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static ArrayList<String> getScreenShot(String str, JSONObject jSONObject) {
        String[] split;
        if (!TextUtils.isEmpty(str) && !NULL_STRING.equals(str)) {
            try {
                String string = jSONObject.getString(str);
                if (string != null && (split = string.split("###")) != null && split.length > 0) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    for (String str2 : split) {
                        arrayList.add(str2);
                    }
                    return arrayList;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String getString(String str, JSONObject jSONObject) {
        try {
            if (jSONObject.isNull(str)) {
                return null;
            }
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static float getFloat(String str) {
        if (!TextUtils.isEmpty(str) && !NULL_STRING.equals(str)) {
            try {
                return Float.valueOf(str).floatValue();
            } catch (Exception unused) {
            }
        }
        return 0.0f;
    }

    public static int getInt(String str) {
        if (!TextUtils.isEmpty(str) && !NULL_STRING.equals(str)) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static long getLong(String str) {
        if (!TextUtils.isEmpty(str) && !NULL_STRING.equals(str)) {
            try {
                return Long.parseLong(str);
            } catch (Exception unused) {
            }
        }
        return 0L;
    }
}
